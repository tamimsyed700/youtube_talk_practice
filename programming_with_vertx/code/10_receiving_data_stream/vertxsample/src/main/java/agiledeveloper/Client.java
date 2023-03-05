package agiledeveloper;

import io.vertx.core.http.HttpMethod;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.core.http.HttpClient;
import io.vertx.rxjava.core.http.HttpClientRequest;

public class Client {
  public static void main(String[] args) {
    final HttpClient httpClient = Vertx.vertx().createHttpClient();

    final HttpClientRequest httpClientRequest = httpClient.request(HttpMethod.GET, 8080, "localhost", "/");

    httpClientRequest.toObservable()
      .flatMap(response -> response.toObservable())
      .subscribe(
        data -> System.out.println(data.toString()),
        err -> System.out.println("ERROR:" + err),
        Client::exit);

    httpClientRequest.end();
    httpClient.close();
  }

  private static void exit() {
    System.out.println("DONE");
    System.exit(0);
  }
}
