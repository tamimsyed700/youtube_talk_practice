public class Mailer {
  public Mailer from(String fromAddress) { return this }
  public Mailer to(String toAddress) { return this }
  public Mailer subject(String theSubject) { return this }
  public Mailer body(String theMessage) { return this }
  public void send() {
    println "Sending message..."
  }
}

new Mailer()
.from('build@agiledeveloper.com')
.to('venkats@agiledeveloper.com')
.subject('build notification')
.body('...whatever...')
.send()
