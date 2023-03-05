package com.agiledeveloper.stockinfo;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class StockService {
  private StockRepository stockRepository;

  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public Iterable<Stock> getStocks() {
    return stockRepository.findAll();
  }

  public Stock getstock(String ticker) {
    return stockRepository.find(ticker);
  }

  public Stock saveStock(Stock stock) {
    return stockRepository.save(stock);
  }
}
