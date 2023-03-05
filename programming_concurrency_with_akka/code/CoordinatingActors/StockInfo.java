package com.agiledeveloper;

public class StockInfo {
  public final String ticker;
  public final double price;

  public StockInfo(String theTicker, double thePrice) {
    ticker = theTicker;
    price = thePrice;
  }

  @Override
  public String toString() {
    return ticker + " at price " + price;
  }
}
