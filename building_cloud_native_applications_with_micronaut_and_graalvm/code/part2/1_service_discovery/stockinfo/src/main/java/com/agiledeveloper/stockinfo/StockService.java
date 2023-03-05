package com.agiledeveloper.stockinfo;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class StockService {
  private List<Stock> stocks;

  public StockService() {
    stocks = List.of(
      new Stock("ORCL", 80),
      new Stock("MSFT", 270),
      new Stock("GOOG", 2600),
      new Stock("AMZN", 3500)
    );
  }

  public List<Stock> getStocks() {
    return stocks;
  }
}
