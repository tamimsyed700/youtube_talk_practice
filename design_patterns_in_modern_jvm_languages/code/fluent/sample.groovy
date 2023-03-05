public class Mailer {
  public void from(String fromAddress) {}
  public void to(String toAddress) {}
  public void subject(String theSubject) {}
  public void body(String theMessage) {}
  
  static void send(closure) {
    Mailer mailer = new Mailer()
    mailer.with closure
    println "Sendinging mail..."
  }
}

Mailer.send {
  from 'build@agiledeveloper.com'
  to 'venkats@agiledeveloper.com'
  subject 'build notification'
  body '...whatever...'
}