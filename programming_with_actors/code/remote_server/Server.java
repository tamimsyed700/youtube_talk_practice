import akka.actor.Actors;
import akka.actor.UntypedActor;

public class Server extends UntypedActor {
  @Override
  public void onReceive(final Object message) throws Exception {
    System.out.println("Received " + message);
  }

  public static void main(String[] args) throws InterruptedException {
    Actors.remote().start("localhost", 8000)
        .register("myserver", Actors.actorOf(Server.class));
    Thread.sleep(600000);
    System.out.println("shutting down...");
    Actors.registry().shutdownAll();
    Actors.remote().shutdown();
  }
}
