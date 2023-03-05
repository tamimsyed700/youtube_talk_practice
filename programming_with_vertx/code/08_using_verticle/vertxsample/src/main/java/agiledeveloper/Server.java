package agiledeveloper;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;

public class Server extends AbstractVerticle {
  @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx
      .createHttpServer()
      .requestHandler(request -> processRequest(request))
      .listen(8080, result -> handleResult(result, startFuture));
  }

  private static void handleResult(AsyncResult<HttpServer> result,
                                   Future<Void> startFuture) {
    if(result.succeeded()) {
      System.out.println("server started...");
      startFuture.complete();
    } else {
      System.out.println("failed to start server " +
        result.cause());
      startFuture.fail(result.cause());
    }
  }

  private static void processRequest(HttpServerRequest request) {
    request.response().end("Hello from Vert.x");
  }
}
