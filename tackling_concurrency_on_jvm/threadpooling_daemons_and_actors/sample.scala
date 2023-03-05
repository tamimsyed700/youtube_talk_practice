import scala.actors._
import Actor._

def createActor(number: Int) = actor {
  for(i <- 1 to 2) {
    receive {
      case _ =>
        val thread = Thread.currentThread
        println(number + " Thread info " + thread + " Daemon? " + thread.isDaemon)
    }
  }
}

for(i <- 1 to 2) {
  println("Notice how thread from thread pool are reused here.")
  val actors = List(
   createActor(1),
   createActor(2),
   createActor(3)
  )
   
  actors.foreach { _ ! "test" }
  actors.foreach { _ ! "test" }
  
  Thread.sleep(1000)
}