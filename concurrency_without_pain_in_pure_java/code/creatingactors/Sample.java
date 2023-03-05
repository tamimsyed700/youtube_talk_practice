import akka.actor.ActorRef;
import akka.actor.Actors;

public class Sample {
 public static void main(String[] args) throws Exception {
   ActorRef depp = Actors.actorOf(HollywoodActor.class).start();

   System.out.println(Thread.currentThread());
   depp.sendOneWay("Sparow");

   depp.sendOneWay("Wonka");

   Actors.registry().shutdownAll();
 }
}