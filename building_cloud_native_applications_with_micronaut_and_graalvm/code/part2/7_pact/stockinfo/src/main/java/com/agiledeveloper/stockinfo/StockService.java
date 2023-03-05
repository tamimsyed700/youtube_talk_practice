package com.agiledeveloper.stockinfo;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class StockService {
  private StockRepository stockRepository;

  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public Flux<Stock> getStocks() {
    return stockRepository.findAll();
  }

  public Mono<Stock> getstock(String ticker) {
    return stockRepository.find(ticker);
  }

  public Publisher<Stock> saveStock(Stock stock) {
    return stockRepository.save(stock);
  }
}
