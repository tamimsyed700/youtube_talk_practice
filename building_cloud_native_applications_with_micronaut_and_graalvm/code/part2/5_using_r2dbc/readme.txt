1. Add dependency to build.gradle

    annotationProcessor("io.micronaut.data:micronaut-data-processor:2.4.7")
    implementation("io.micronaut.data:micronaut-data-r2dbc")
    implementation("io.micronaut.r2dbc:micronaut-r2dbc-core")
    runtimeOnly("io.r2dbc:r2dbc-h2")

2. Edit appication.yml

micronaut:
  application:
    name: stockinfo
  server:
    port: -1

consul:
  client:
    registration:
      enabled: true
    defaultZone: ${CONSUL_HOST:localhost}:${CONSUL_PORT:8500}

r2dbc:
  datasources:
    default:
      schema-generate: CREATE_DROP
      dialect: H2
      url: r2dbc:h2:mem:///stocksdb;DB_CLOSE_ON_EXIT=FALSE
      username: sa
      password: ''
      options:
        DB_CLOSE_DELAY: -1
        protocol: mem

3. Modify the Stock entity

package com.agiledeveloper.stockinfo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@Introspected
@MappedEntity
public class Stock {
  @Id
  @GeneratedValue
  private Long id;
...

4. Create a StockRepository

package com.agiledeveloper.stockinfo;


import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@R2dbcRepository(dialect = Dialect.H2)
public interface StockRepository extends ReactiveStreamsCrudRepository<Stock, Long> {
  Mono<Stock> find(String ticker);
  Flux<Stock> findAll();
}

5. Modify the service

package com.agiledeveloper.stockinfo;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.inject.Singleton;

@Singleton
public class StockService {
  private StockRepository stockRepository;

  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public Flux<Stock> getStocks() {
    return stockRepository.findAll();
  }

  public Mono<Stock> getstock(String ticker) {
    return stockRepository.find(ticker);
  }

  public Publisher<Stock> saveStock(Stock stock) {
    return stockRepository.save(stock);
  }
}

6. Modify the controller

package com.agiledeveloper.stockinfo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller("/")
public class StockController {
  private StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @Get("/{ticker}")
  public Mono<Stock> getStock(String ticker) {
    return stockService.getstock(ticker);
  }

  @Get
  public Flux<Stock> getStocks() {
    return stockService.getStocks();
  }
}

7. Let's create some sample data

@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
    @Inject
    StockService stockService;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "ORCL", 80)))).block();

        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "MSFT", 180)))).block();

        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "GOOG", 1180)))).block();

        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "AMZN", 3180)))).block();
    }


8. Modify client build.gradle to include

    implementation("io.micronaut.data:micronaut-data-r2dbc")

9. Modify the StockClient

package com.agiledeveloper.stockclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Client(id = "stockinfo")
@CircuitBreaker
public interface StockClient {
  @Get("/{ticker}")
  Mono<Stock> getStock(String ticker);

  @Get
  Flux<Stock> getStocks();
}

10. Edit the main for the client:

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(StockclientCommand.class, args);
    }

    private CountDownLatch latch = new CountDownLatch(2);

    public void run() {
        stockClient.getStocks()
          .subscribe(System.out::println, System.out::println, () -> latch.countDown());

        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

11. Run the service and the client.

