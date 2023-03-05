package pagerank
import org.apache.spark._
import org.apache.spark.graphx._

object GraphHelper {
  def createEdge(line: String) = {
    val parts = line.split(" ")

    new Edge[Int](parts(0).toLong, parts(1).toLong, 1)    
  }

  def createEdges(sparkContext: SparkContext, filePath: String) = {
    sparkContext.textFile(filePath)
                .map(line => createEdge(line))
  }
}