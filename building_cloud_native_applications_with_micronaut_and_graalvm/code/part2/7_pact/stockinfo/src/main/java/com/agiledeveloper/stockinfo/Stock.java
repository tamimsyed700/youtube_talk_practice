package com.agiledeveloper.stockinfo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@Introspected
@MappedEntity
public class Stock {
  @Id
  @GeneratedValue
  private Long id;

  private String ticker;
  private int price;

  public Stock() {
  }

  public Stock(Long id, String ticker, int price) {
    this.id = id;
    this.ticker = ticker;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
