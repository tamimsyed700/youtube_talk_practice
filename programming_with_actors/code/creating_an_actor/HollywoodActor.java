import akka.actor.UntypedActor;

public class HollywoodActor extends UntypedActor {
  @Override
  public void onReceive(final Object role) throws Exception {
    System.out.println("Playing " + role +
     " " + Thread.currentThread());
    System.out.println("done with role " + role);
  }
}
