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
    return stockService.getstock(ticker);
  }
}
