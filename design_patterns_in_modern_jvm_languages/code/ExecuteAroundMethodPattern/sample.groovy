class Resource {
  def static use(closure) {
    Resource resource = new Resource()
    println "construction"
    try {
      closure(resource)
    } finally {
      println "cleanup..."
    }
  }
  
  def op1() { println  "op1" }
  def op2() { println "op2" }
}

Resource.use { resource ->
  resource.op1()
  resource.op2()
}