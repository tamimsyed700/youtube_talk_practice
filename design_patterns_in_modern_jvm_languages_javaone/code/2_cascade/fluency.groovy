class Mailer {
  def to(addr) { println "to..." }
  def from(addr) { println "from..." }
  def sub(subject) { println "sub..." }
  def body(msg) { println "body..." }
  def static send(block) { 
    Mailer mailer = new Mailer()
    mailer.with block
    println "send..." 
  }
}

Mailer.send {
  to 'venkats@agiledeveloper.com'
  from 'builder@agiledeveloper.com'
  sub 'build fixed'
  body '...message...'
}