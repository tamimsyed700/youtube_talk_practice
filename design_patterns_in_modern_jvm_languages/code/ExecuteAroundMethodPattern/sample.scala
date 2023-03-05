class Resource private() {
  def op1() { println("op1") }
  def op2() { println("op2") }
}

object Resource {
  def use(closure : Resource => Unit) {
    val resource = new Resource
    println("construction")
    try {
      closure(resource)
    } finally {
      println("cleanup...")
    }
  }
}

Resource.use { resource =>
  resource.op1()
  resource.op2()
}