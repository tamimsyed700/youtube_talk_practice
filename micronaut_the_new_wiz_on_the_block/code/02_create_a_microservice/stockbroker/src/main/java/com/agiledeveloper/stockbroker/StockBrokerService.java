package com.agiledeveloper.stockbroker;

import javax.inject.Singleton;
import com.agiledeveloper.stocks.Stock;

@Singleton
public class StockBrokerService {
  public Stock priceFor(String ticker) {
    return new Stock(ticker, (int)(Math.random() * 1000));
  }
}