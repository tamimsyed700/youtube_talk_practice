package com.agiledeveloper.stockinfo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller("/stocks")
public class StockController {
  private StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @Get("/{ticker}")
  public Mono<Stock> getStock(String ticker) {
    return stockService.getstock(ticker);
  }

  @Get
  public Flux<Stock> getStocks() {
    return stockService.getStocks();
  }
}
