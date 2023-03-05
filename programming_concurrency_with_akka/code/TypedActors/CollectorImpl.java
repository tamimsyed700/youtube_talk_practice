package com.agiledeveloper;

public class CollectorImpl implements Collector {
  private int itemsCount = 1000;

  public void buy(int quantity) {
    System.out.println("buying..." + Thread.currentThread());
    itemsCount++;
  }

  public void sell(int quantity) {
    System.out.println("selling...." + Thread.currentThread());
    itemsCount--;
  }

  public int getItemsCount() {
    System.out.println("getting..." + Thread.currentThread());
    return itemsCount;
  }
}
