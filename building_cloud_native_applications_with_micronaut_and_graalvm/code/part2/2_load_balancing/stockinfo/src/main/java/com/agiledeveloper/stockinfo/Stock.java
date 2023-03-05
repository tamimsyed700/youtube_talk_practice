package com.agiledeveloper.stockinfo;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Stock {
  private String ticker;
  private int price;

  public Stock() {}

  public Stock(String ticker, int price) {
    this.ticker = ticker;
    this.price = price;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
