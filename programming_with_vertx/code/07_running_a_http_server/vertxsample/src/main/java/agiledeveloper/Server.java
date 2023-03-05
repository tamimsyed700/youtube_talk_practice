package agiledeveloper;

import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;

public class Server {
  public static void main(String[] args) {
    Vertx.vertx()
      .createHttpServer()
      .requestHandler(request -> processRequest(request))
      .listen(8080, result -> handleResult(result));
  }

  private static void handleResult(AsyncResult<HttpServer> result) {
    if(result.succeeded()) {
      System.out.println("server started...");
    } else {
      System.out.println("failed to start server " +
        result.cause());
    }
  }

  private static void processRequest(HttpServerRequest request) {
    request.response().end("Hello from Vert.x");
  }
}