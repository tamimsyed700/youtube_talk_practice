package agiledeveloper;

import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.core.http.HttpClient;
import io.vertx.rxjava.core.http.HttpClientRequest;

public class Client extends AbstractVerticle {
  static final String EVENT_NAME = "greet";

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    System.out.println("A client started...");
                         
    vertx.eventBus().consumer(EVENT_NAME, message -> System.out.println("Received message: " + message.body()));
  }
}
