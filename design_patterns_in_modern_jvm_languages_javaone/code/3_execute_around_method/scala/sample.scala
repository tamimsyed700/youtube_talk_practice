//See the Java example for the reasons to go this route.
class MyResource private {
  println("Creating expensive resource")
  
  def op1() = println("operation 1")
  def op2() = println("operation 2")
  private def cleanup() = println("cleaning up")
}

object MyResource {
  def use(closure : MyResource => Unit) = {
    val resource = new MyResource
    try {
      closure(resource)
    } finally {
      resource.cleanup();
    }
  }
}

MyResource.use { resource =>
  resource.op1()
  resource.op2()
}