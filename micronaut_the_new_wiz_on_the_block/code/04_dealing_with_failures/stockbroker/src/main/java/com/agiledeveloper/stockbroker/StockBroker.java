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
    //Shutdown all running instances of this microservice and see how the Fallback is called.
    //Also, add a sleep(30000) to this code and see how the circuitbreaker kicks in
    
    System.out.println("received request for ticket " + ticker);

    return service.priceFor(ticker);
  }
}