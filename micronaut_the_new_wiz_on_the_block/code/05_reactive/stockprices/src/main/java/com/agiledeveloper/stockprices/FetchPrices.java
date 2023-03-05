package com.agiledeveloper.stockprices;

import io.micronaut.http.annotation.*;              
import java.util.stream.*;
import java.util.*;
import static java.util.stream.Collectors.*;
import com.agiledeveloper.stocks.Stock;
import io.reactivex.*;

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

  //first run with the above code. See how the response is delayed until all values are computed.
  //The commented out the top code and try the bottom code uncommented.

//  @Get("/prices/{tickers}")
//  public Flowable<Stock> getPrices(String tickers) {
//    String[] tickerSymbols = tickers.split(",");
//    Arrays.sort(tickerSymbols);
//    
//    return Flowable.fromArray(tickerSymbols)
//      .map(client::priceFor);
//  }
}