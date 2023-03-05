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
  @Override
  public void start(Future<Void> startFuture) throws Exception {
    final HttpServer httpServer = vertx.createHttpServer();

    processRequest(httpServer.requestStream());

    httpServer.listen(8080, handler -> listen(handler, startFuture));
  }

  private void processRequest(HttpServerRequestStream httpServerRequestStream) {
    httpServerRequestStream.toObservable()
      .subscribe(request -> handleRequest(request));
  }

  private void handleRequest(HttpServerRequest request) {
    final HttpServerResponse response = request.response();
    response.setChunked(true);

    Observable.interval(1, 1, TimeUnit.SECONDS)
      .map(index -> response.write(index.toString()))
      .limit(20)
      .last()
      .subscribe(
        HttpServerResponse::end,
        err -> System.out.println("ERROR: " + err));
  }

  private void listen(AsyncResult<HttpServer> handler, Future<Void> startFuture) {
    if(handler.succeeded()) {
      startFuture.complete();
      System.out.println("Severver started...");
    } else {
      System.out.println("failure " + handler.cause());
      startFuture.fail(handler.cause());
    }
  }
}