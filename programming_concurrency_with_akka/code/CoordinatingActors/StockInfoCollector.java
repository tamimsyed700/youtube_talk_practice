package com.agiledeveloper;

import akka.actor.UntypedActor;

public class StockInfoCollector extends UntypedActor {
  final long start = System.nanoTime();
  int numberOfStockInfoReceived = 0;
  int expectedNumberOfStockInfo = Integer.MAX_VALUE;
  StockInfo highestPriced = new StockInfo("", 0.0);

  @Override
  public void onReceive(final Object message) {
    if(message instanceof Integer) {
      expectedNumberOfStockInfo = ((Integer)(message)).intValue();
    } else {
      numberOfStockInfoReceived++;
      StockInfo tickerAndPrice = (StockInfo)(message);
      if(tickerAndPrice.price > highestPriced.price)
        highestPriced = tickerAndPrice;

      if(numberOfStockInfoReceived == expectedNumberOfStockInfo) {
        final long end = System.nanoTime();

        System.out.println("Highest priced stock is " + highestPriced);
        System.out.println("Time taken: " + (end - start) / 1.0e9);
        getContext().system().shutdown();
      }
    }
  }
}
