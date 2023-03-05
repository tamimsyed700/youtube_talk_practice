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
    return service.priceFor(ticker);
  }
}