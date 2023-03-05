package com.agiledeveloper.stockprices;

import io.micronaut.http.annotation.*;              
import java.util.stream.*;
import java.util.*;
import static java.util.stream.Collectors.*;
import com.agiledeveloper.stocks.Stock;

@Controller("/")
public class FetchPrices {
  private StockBrokerClient client;
  
  public FetchPrices(StockBrokerClient stockBrokerClient) {
    client = stockBrokerClient;
  }
  
  @Get("/prices/{tickers}")
  public List<Stock> getPrices(String tickers) {
    return Stream.of(tickers.split(","))
      .sorted()
      .map(client::priceFor)
      .collect(toList());
  }
}