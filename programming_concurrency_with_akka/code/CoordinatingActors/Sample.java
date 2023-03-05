package com.agiledeveloper;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
  public static void main(String[] args) {
    doSequential();
    //Sequential run...
    //Highest priced stock is GOOG at price 677.14
    //Time taken: 12.421853

    doConcurrent();
    //Concurrent run...
    //Highest priced stock is GOOG at price 677.14
    //Time taken: 1.429331
  }

  private static void doSequential() {
    System.out.println("Sequential run...");
    final long start = System.nanoTime();
    StockInfo highestPriced = new StockInfo("", 0.0);

    for (String ticker : Stocks.tickers) {
      StockInfo tickerAndPrice =
          new StockInfo(ticker, YahooFinance.getPrice(ticker));

      if (tickerAndPrice.price > highestPriced.price)
        highestPriced = tickerAndPrice;
    }

    final long end = System.nanoTime();

    System.out.println("Highest priced stock is " + highestPriced);
    System.out.println("Time taken: " + (end - start) / 1.0e9);
  }


  private static void doConcurrent() {
    System.out.println("Concurrent run...");

    final ActorSystem actorSystem = ActorSystem.create();
    final ActorRef stockInfoCollector = actorSystem.actorOf(new Props(StockInfoCollector.class));

    stockInfoCollector.tell(Stocks.tickers.length);

    final ExecutorService executorService = Executors.newFixedThreadPool(100);

    for(String ticker : Stocks.tickers) {
      final String aTicker = ticker;
      executorService.submit(new Runnable() {
        public void run() {
          stockInfoCollector.tell(
              new StockInfo(aTicker, YahooFinance.getPrice(aTicker)));
        }
      });
    }

    executorService.shutdown();
  }
}
