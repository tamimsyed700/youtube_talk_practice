package pagerank

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.graphx.GraphOps
import org.apache.log4j._

object PageRank extends App {
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

    val graph : Graph[Node, Int] = Graph.fromEdges(edges, new Node)

    useBuiltinFunction(graph);
    
    useHandCraftedFunction(graph);
  }    
  
  
  def useBuiltinFunction(graph: Graph[Node, Int]) = {
    println("using built in function:")
    val pageRanks = graph.staticPageRank(12, 0.15)

    val result = 
      pageRanks.vertices
               .collect()
                                         
    for(vertex <- result) {
      println(vertex)
    }
  }

  def useHandCraftedFunction(graph: Graph[Node, Int]) = {
    println("using hand-crafted function:")

    //http://pr.efactory.de/e-pagerank-algorithm.shtml
    //PR(A) = (1-d) + d (PR(T1)/C(T1) + ... + PR(Tn)/C(Tn))
    //PR - rank of a page A
    //PR(Ti) - rank of page Ti that links to A
    //C(Ti) - number of outgoing edges from Ti

    val outDegree = 
      graph.aggregateMessages[Long](context => context.sendToSrc(1), _ + _ )

    val graphWithDegree =
      graph.outerJoinVertices(outDegree) {
        (id, node, outDegree) => new Node(outDegree.getOrElse(0), 1)
    }
    
    val numberOfIterations = 12
                 
    val graphWithRank = 
      (1 to numberOfIterations).foldLeft(graphWithDegree) {
        (updatedGraph, iteration) => updateGraphRank(updatedGraph)
      } 

    printGraphRank(graphWithRank);
  }

  def printGraphRank(graph: Graph[Node, Int]) = {
    graph.vertices.collect().foreach(println)
  }

  def sendRankFactorToDestination(context: EdgeContext[Node, Int, Double]) = {
    val sourceNode = context.srcAttr
    val rankFactor = sourceNode.rank / sourceNode.outDegree
    context.sendToDst(rankFactor)
  }
  
  def sumOfRanks(rankOfASource: Double, rankOfAnotherSource: Double) =
    rankOfASource + rankOfAnotherSource                                 
    
  def updateNodeRank(node: Node, rankFactor: Double) = {
    val DAMPING_FACTOR = 0.5
    val updatedRank = (1 - DAMPING_FACTOR) + DAMPING_FACTOR * rankFactor;
    
    new Node(node.outDegree, updatedRank)
  }
  
  def updateGraphRank(graph: Graph[Node, Int]) = {
    val rankFactors =
      graph.aggregateMessages[Double](sendRankFactorToDestination, sumOfRanks)
          
    graph.outerJoinVertices(rankFactors) {
      (id, node, rankFactor) => updateNodeRank(node, rankFactor.getOrElse(0))
    }
  }
}
