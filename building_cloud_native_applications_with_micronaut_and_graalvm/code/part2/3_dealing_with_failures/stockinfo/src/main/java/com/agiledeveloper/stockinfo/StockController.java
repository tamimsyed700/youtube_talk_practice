package com.agiledeveloper.stockinfo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

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
  public Stock getStock(String ticker) {
    System.out.println("received request for " + ticker);

    if(Math.random() > 0.8) {
      System.out.println("Simulate failure...");
      throw new RuntimeException("oops, something went wrong");
    }

    return stockService.getStocks().stream()
      .filter(stock -> stock.getTicker().equals(ticker))
      .findFirst()
      .orElse(null);
  }

  @Get
  public Flowable<Stock> getStocks() {
    List<Stock> stocks = stockService.getStocks();

    return Flowable.interval(1, 1, TimeUnit.SECONDS)
      .map(index -> stocks.get(index.intValue()))
      .take(stocks.size());
  }
}
