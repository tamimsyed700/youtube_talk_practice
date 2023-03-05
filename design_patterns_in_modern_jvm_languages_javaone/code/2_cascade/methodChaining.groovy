class Mailer {
  def to(addr) { println "to..."; this }
  def from(addr) { println "from..."; this }
  def sub(subject) { println "sub..."; this }
  def body(msg) { println "body..."; this }
  def send() { println "send..." }
}

//Traditional way

Mailer mailer = new Mailer()
mailer.to('venkats@agiledeveloper.com')
mailer.from('builder@agiledeveloper.com')
mailer.sub('build fixed')
mailer.body('...message...')
mailer.send()

//Chaining
new Mailer()
 .to('venkats@agiledeveloper.com')
 .from('builder@agiledeveloper.com')
 .sub('build fixed')
 .body('...message...')
 .send()
