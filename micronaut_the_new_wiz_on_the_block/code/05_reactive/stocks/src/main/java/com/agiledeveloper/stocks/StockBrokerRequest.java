package com.agiledeveloper.stocks;

public interface StockBrokerRequest {
  public Stock priceFor(String ticker);
}