package pagerank

class Node(val outDegree: Long = 0, val rank: Double = 1) 
  extends java.io.Serializable {

  override def toString() = { s"Node outDegree: ${outDegree} rank: ${rank}" }
}