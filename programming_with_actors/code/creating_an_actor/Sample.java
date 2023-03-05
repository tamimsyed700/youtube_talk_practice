import akka.actor.ActorRef;
import akka.actor.Actors;

public class Sample {
  public static void main(String[] args) throws InterruptedException {
    ActorRef depp = Actors.actorOf(HollywoodActor.class).start();

    System.out.println("In main " + Thread.currentThread());

    depp.sendOneWay("Wonka");
    depp.sendOneWay("Sparrow");

    Thread.sleep(1000);
    depp.sendOneWay("Scissorhands");

    depp.stop();
  }
}
