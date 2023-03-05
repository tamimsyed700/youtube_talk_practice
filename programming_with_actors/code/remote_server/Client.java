import akka.actor.ActorRef;
import akka.actor.Actors;

import java.util.Date;

public class Client {
  public static void main(String[] args) {
    ActorRef server = Actors.remote().actorFor("myserver", "localhost", 8000);
    server.sendOneWay("hello " + new Date().toString());
    System.out.println("done");
    Actors.remote().shutdown();
  }
}
