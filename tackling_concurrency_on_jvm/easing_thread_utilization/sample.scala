import scala.actors._
import Actor._

def method1(number: Int) {
  for(i <- 1 to 2) {
    receive {
      case _ =>
        println(number + ": Thread " + Thread.currentThread)
    }
  }
}                            

def method2(number: Int) {
  react {
    case _ =>
      println(number + ": Thread " + Thread.currentThread)
      method2(number)
  }
}

val actors = List(
  actor { method1(1) },
  actor { method1(2) },
  actor { method2(3) },
  actor { method2(4) }
)
                             
println("Notice 1 and 2 are fixed to a particular thread while 3 and 4 may switch threads")
actors.foreach { _ ! "test" }
Thread.sleep(1000)
actors.foreach { _ ! "test" }