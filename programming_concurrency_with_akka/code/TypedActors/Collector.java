package com.agiledeveloper;

public interface Collector {
  public void buy(int quantity);
  public void sell(int quantity);
  public int getItemsCount();
}
