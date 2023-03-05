import scala.io._

println(Source.fromFile("/etc/hosts").mkString)