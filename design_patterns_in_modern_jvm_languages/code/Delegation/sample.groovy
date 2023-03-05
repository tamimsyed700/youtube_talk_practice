class Worker {
  def code() { println "coding..." }
  def writeReport() { println "writing..."}
  def learn() { println  "learning..." }
}

class ExpertWorker {
  def code() { println "expert coding..." }
}

class Manager {
  @Delegate ExpertWorker expert = new ExpertWorker()
  @Delegate Worker worker = new Worker()
  
  def schedule() { println "Schedlue..." }
}

bob = new Manager()
bob.code()
bob.writeReport()
bob.schedule()
bob.learn()