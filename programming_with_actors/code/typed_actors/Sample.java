import akka.actor.ActorRef;
import akka.actor.TypedActor;

//The simulated delays in the actor will help us see the execution sequence of
//the method calls from main. If you don't set the timeout (10000), your get call
//will fail as the actor is busy responding to previous calls.

public class Sample {
  public static void main(String[] args) {
    Collector collector = TypedActor.newInstance(Collector.class, CollectorImpl.class, 10000);
    System.out.println("Number of items " + collector.getNumberOfItems());

    collector.sellItems(100);
    System.out.println("asked to sell");
    collector.sellItems(200);
    System.out.println("asked to sell");
    collector.buyItems(250);
    System.out.println("asked to buy");

    System.out.println("checking number of items...");
    System.out.println("Number of items " + collector.getNumberOfItems());

    TypedActor.stop(collector);
  }
}
