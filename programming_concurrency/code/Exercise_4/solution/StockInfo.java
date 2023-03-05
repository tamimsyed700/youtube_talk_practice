package com.agiledeveloper;

import java.util.*;
import java.util.concurrent.*;
import akka.actor.*;

public class StockInfo {
  static List<String> tickers = Arrays.asList("AAPL", "AMGN", "AMZN", "BAC", "BMY", 
  "CAT", "C", "CMCSA", "CSCO", "CVX", "DELL", "DIS", "DOW", "EMC", "FDX", "GD", 
  "GE", "GOOG", "HAL", "HNZ", "HPQ", "IBM", "INTC", "JPM", "KFT", "LMT", "MET", 
  "MO", "MSFT", "NKE", "NSC", "ORCL", "PFE", "RTN", "S", "SO","TXN", "USB", 
  "VZ", "WMT");
  
  public static void main(String[] args) {
    sequentialRun();
    concurrentRun();
  }
  
  public static void sequentialRun() {
    System.out.println("Sequential run");
    final long start = System.nanoTime();
    double lowPrice = Integer.MAX_VALUE;
    String lowTicker = "";
    double highPrice = 0;
    String highTicker = "";
    
    for(String ticker : tickers) {
      double price = YahooFinance.getPrice(ticker);
      if (price < lowPrice) {
        lowPrice = price;
        lowTicker = ticker;
      }
      if (price > highPrice) {
        highPrice = price;
        highTicker = ticker;
      }
    }
    
    final long end = System.nanoTime();
    System.out.println("High is " + highTicker + " - " + highPrice);
    System.out.println("Low is " + lowTicker + " - " + lowPrice);
    System.out.println("Time " + (end - start) / 1.0e9);
  }
  
  public static void concurrentRun() {
    System.out.println("Concurerent run");
    final ActorRef stockInfoActor = Actors.actorOf(StockInfoActor.class).start();
    
    stockInfoActor.sendOneWay(tickers.size());
    
    ExecutorService service = Executors.newFixedThreadPool(50);
 
    for(String ticker : tickers) {
      final String aTicker = ticker;
      service.execute(new Runnable() {
        public void run() {
          stockInfoActor.sendOneWay(aTicker + ":" + YahooFinance.getPrice(aTicker));
        }
      });
    }
    
    service.shutdown();
  }
}