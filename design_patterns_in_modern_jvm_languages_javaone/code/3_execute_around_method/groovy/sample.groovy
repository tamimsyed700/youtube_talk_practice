//See the Java example for the reasons to go this route.
class MyResource {
  MyResource() { println 'Creating expensive resource' }
  
  def op1() { println 'operation 1' }
  def op2() { println 'operation 2' }
  def cleanup() { println 'cleaning up' }
  
  def static use(closure) {
    MyResource resource = new MyResource()
    try {
      resource.with closure
    } finally {
      resource.cleanup();
    }
  }
}

MyResource.use { 
  op1()
  op2()
}