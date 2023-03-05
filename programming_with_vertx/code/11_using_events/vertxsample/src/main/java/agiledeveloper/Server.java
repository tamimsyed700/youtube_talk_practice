package agiledeveloper;


import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.core.http.HttpServerRequestStream;
import io.vertx.rxjava.core.http.HttpServerResponse;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Server extends AbstractVerticle {
  static final String EVENT_NAME = "greet";
  
  int count = 0;
  
  @Override
  public void start(Future<Void> startFuture) throws Exception {
    System.out.println("Server started...");     

    vertx.setPeriodic(5000, this::emitMessage);
  }
  
  public void emitMessage(long id) {
    System.out.println("Sending a message");
    vertx.eventBus().publish(EVENT_NAME, "message " + count++);
  }
}