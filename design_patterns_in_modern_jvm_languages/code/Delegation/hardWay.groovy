class Worker {
  def code() { println "coding..." }
  def writeReport() { println "writing..." }
}

class Manager {
  Worker worker = new Worker()
  
  def code() { worker.code() }
  def writeReport() { worker.writeReport() }
  
  def schedule() { println "scheduling..." }
}

bob = new Manager()
bob.code()
bob.writeReport()

//not extensible
