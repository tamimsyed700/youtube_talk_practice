package com.agiledeveloper.stockbroker;

import io.micronaut.http.annotation.*;
import com.agiledeveloper.stocks.Stock;
         
@Controller("/")
public class StockBroker {          
  private StockBrokerService service;
  
  public StockBroker(StockBrokerService stockBrokerService) {
    service = stockBrokerService;
  }
  
  @Get("/price/{ticker}")
  public Stock priceFor(String ticker) {
    //run a few instances of this Microservice and see how the stockprices service loadbalances between the instances
    System.out.println("received request for ticket " + ticker);

    return service.priceFor(ticker);
  }
}