package pagerank

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.graphx.GraphOps
import org.apache.log4j._
import scala.util.Random

object RandomWalk extends App {
  val epsilon = 0.15
  val cp = 1
  val c: Double = 2 / (cp * epsilon)
  
  processGraph

  def processGraph = {
    Logger.getLogger("org")
          .setLevel(Level.OFF)

    val sparkConf =
        new SparkConf()
            .setAppName("page-rank")
            .setMaster("local[8]")

    val sparkContext = new SparkContext(sparkConf)

    val filePath = "./Sample.txt"
                                              
    val edges = GraphHelper.createEdges(sparkContext, filePath);
    
    val numberOfNodes = edges.map(_.srcId).distinct().collect().size
    val k = Math.round(c * math.log(numberOfNodes)).toInt

    val graph : Graph[NodeForRandomWalk, Int] = 
      Graph.fromEdges(edges, new NodeForRandomWalk(k))

    val connectedVertices = 
      graph.collectNeighborIds(EdgeDirection.Out)
           .collect()
           .foldLeft(Map[VertexId, Array[VertexId]]()) {
             (map, collectedVertices) =>
               map + (collectedVertices._1 -> collectedVertices._2)
            }

             
   printGraph(
     walk(graph, connectedVertices)
       .filter(noNodeHasMessageToSend)
       .take(1)
       .toList(0))
  }

  def noNodeHasMessageToSend(graph: Graph[NodeForRandomWalk, Int]) = {
    graph.vertices
      .filter(vertex => vertex._2.numberOfMessagesToSend == 0)
      .collect()
      .size == graph.numVertices
  }

  def walk(graph: Graph[NodeForRandomWalk, Int], 
    connectedVertices: Map[VertexId, Array[VertexId]]) :
    Stream[Graph[NodeForRandomWalk, Int]] = {

    val graphBeforeWalk = prepareToWalk(graph, connectedVertices)
    val graphAfterWalk = takeAWalk(graphBeforeWalk)
                 
    graphAfterWalk #:: walk(graphAfterWalk, connectedVertices)
  }
  
  def prepareToWalk(
    graph: Graph[NodeForRandomWalk, Int], 
    connectedVertices: Map[VertexId, Array[VertexId]]) = {

    graph.mapVertices((id, node) =>
    
      new NodeForRandomWalk(
        0,
        node.totalNumberOfWalks,
        decideNodeToWalkTo(
          id, node.numberOfMessagesToSend, connectedVertices(id))))
  }

  def decideNodeToWalkTo(
      id: VertexId,
      numberOfMessagesToSend: Int, 
      connectedVertices: Array[VertexId]) = {
        
      List(1 to numberOfMessagesToSend)
        .filter(index => connectedVertices.length > 0)
        .filter(index => (new Random).nextFloat() > epsilon)
        .map(index => 
          connectedVertices((new Random).nextInt(connectedVertices.length)))
  }
  
  def sendMessageToNodeDecidedForWalk(
    context: EdgeContext[NodeForRandomWalk, Int, Int]) = {
  
    val sourceNode = context.srcAttr            
    val destinationId = context.dstId
    
    if(sourceNode.nodesToSendMessageTo.contains(destinationId))
      context.sendToDst(1)
  }
  
  def takeAWalk(graph: Graph[NodeForRandomWalk, Int]) = {
    val walks =
      graph.aggregateMessages[Int](sendMessageToNodeDecidedForWalk, _ + _)
          
    graph.outerJoinVertices(walks) {
      (id, node, walk) => updateNodeWalk(node, walk.getOrElse(0))
    }
  }
  
  def updateNodeWalk(node: NodeForRandomWalk, walk: Int) = {
    new NodeForRandomWalk(walk, node.totalNumberOfWalks + walk)
  }
  
  def printGraph(graph: Graph[NodeForRandomWalk, Int]) = {
    println("----------------------")
    val numberOfVertices = graph.numVertices
    
    graph.vertices.collect().foreach {
      vertex => println(vertex + " " +
        vertex._2.totalNumberOfWalks * 
          epsilon / (c * numberOfVertices * math.log(numberOfVertices)))
    }
  }
}