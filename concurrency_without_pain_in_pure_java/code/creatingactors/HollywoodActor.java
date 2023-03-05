import akka.actor.UntypedActor;

public class HollywoodActor extends UntypedActor {
  public void onReceive(Object message) {
    System.out.println(Thread.currentThread());
    System.out.println("Playing..." + message);
  }

}
