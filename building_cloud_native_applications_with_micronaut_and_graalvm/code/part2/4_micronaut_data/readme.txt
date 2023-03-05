1. Bring in the dependencies into build.gradle

    annotationProcessor("io.micronaut.data:micronaut-data-processor:2.4.7")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:2.4.7")
    runtimeOnly("io.micronaut.sql:micronaut-jdbc-tomcat")
    runtimeOnly("com.h2database:h2")

2. Edit application.yml

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

datasources:
  default:
    url: jdbc:h2:mem:stocksdb
    driverClassName: org.h2.Driver
    username: sa
    password: ''
    schema-generated: CREATE
    dialect: H2

jpa:
  default:
    entity-scan:
      packages: 'com.agiledeveloper'
    properties:
      hibernate:
        hbm2ddl:
          auto: update
          show_sql: true


3. Create a StockRepository interface.

package com.agiledeveloper.stockinfo;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
  @Executable
  Stock find(String ticker);
}


4. Edit the Stock class to make it an entity:

@Introspected
@Entity
public class Stock {
  @Id
  @GeneratedValue
  private Long id;

Provide getter and setter for id and also take it as a parameter in the constructor:

  public Stock(Long id, String ticker, int price) {

5. Modify the service to use the repository:

package com.agiledeveloper.stockinfo;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class StockService {
  private StockRepository stockRepository;

  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }
  
  public Iterable<Stock> getStocks() {
    return stockRepository.findAll();
  }

  public Stock getstock(String ticker) {
    return stockRepository.find(ticker);
  }

  public Stock saveStock(Stock stock) {
    return stockRepository.save(stock);
  }
}

6. Modify the controller to use the service after change:

@Controller("/")
public class StockController {
  private StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @Get("/{ticker}")
  public Stock getStock(String ticker) {
    return stockService.getstock(ticker);
  }
}

7. Create some sample data in the Application:

package com.agiledeveloper.stockinfo;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
    @Inject
    StockService stockService;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        stockService.saveStock(new Stock(null, "ORCL", 80));
        stockService.saveStock(new Stock(null, "MSFT", 180));
        stockService.saveStock(new Stock(null, "GOOG", 1180));
        stockService.saveStock(new Stock(null, "AMZN", 3080));
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}

8. Run the service and the client.

