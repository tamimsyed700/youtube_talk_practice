package pagerank

import org.apache.spark.graphx._

class NodeForRandomWalk(
  val numberOfMessagesToSend: Int, 
  val totalNumberOfWalks: Long = 0, 
  val nodesToSendMessageTo: List[VertexId] = List()) 
  extends java.io.Serializable {

  override def toString() = { 
    s"Node TotalNumberOfWalks: ${totalNumberOfWalks} numberOfMessagesToSend: ${numberOfMessagesToSend} nodesToSendMessageTo: ${nodesToSendMessageTo}"
  }
}