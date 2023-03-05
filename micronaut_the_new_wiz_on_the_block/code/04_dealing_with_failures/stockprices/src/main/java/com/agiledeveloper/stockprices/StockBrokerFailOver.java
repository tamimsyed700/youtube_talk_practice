package com.agiledeveloper.stockprices;
 
import io.micronaut.retry.annotation.*;
import com.agiledeveloper.stocks.*;         
 
@Fallback
public class StockBrokerFailOver implements StockBrokerRequest {
  public Stock priceFor(String ticker) {
    return new Stock(ticker, 0);
  }
}