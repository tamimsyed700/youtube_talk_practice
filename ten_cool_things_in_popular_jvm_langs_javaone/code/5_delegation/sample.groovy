class Worker {
  def work() { println 'working...' }
  def report() { println 'writing...' }
  def vacation() { println 'code at the beach...' }
}

class Analyst {
  def work() { println "analyst working..." }
  def analyze() { println "analyzing..." }
}

class Manager {
  @Delegate Worker worker = new Worker()
  @Delegate Analyst analyst = new Analyst()
  
  def vacation() { println "Yay" }
}

def bob = new Manager()
bob.work()
bob.analyze()
bob.report()
bob.vacation()

//working...