public class Mailer {
  public void from(String fromAddress) {}
  public void to(String toAddress) {}
  public void subject(String theSubject) {}
  public void body(String theMessage) {}
  public void send() {
    println "Sending message..."
  }
}

Mailer mailer = new Mailer()
mailer.from('build@agiledeveloper.com')
mailer.to('venkats@agiledeveloper.com')
mailer.subject('build notification')
mailer.body('...whatever...')
mailer.send()

//Noisy
//Is mailer instance reusable?