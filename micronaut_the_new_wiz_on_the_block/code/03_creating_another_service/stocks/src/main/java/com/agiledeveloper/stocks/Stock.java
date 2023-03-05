package com.agiledeveloper.stocks;

public class Stock {
  private String ticker;
  private int price;
  
  public Stock() {}
  public Stock(String theTicker, int thePrice) {
    ticker = theTicker;
    price = thePrice;
  }                  
  
  public String getTicker() { return ticker; }
  public int getPrice() { return price; }
}