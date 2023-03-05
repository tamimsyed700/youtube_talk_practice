package com.agiledeveloper;

import akka.actor.*;

public class StockInfoActor extends UntypedActor {
  int count;
  int NumberOfTickers = Integer.MAX_VALUE;
  double lowPrice = Integer.MAX_VALUE;
  String lowTicker = "";
  double highPrice = 0;
  String highTicker = "";
  long start = System.nanoTime();
    
  public void onReceive(final Object message) {
    if (message instanceof Integer) {
      NumberOfTickers = (Integer) message;
    }
    
    if (message instanceof String) {
      count++;
      String[] theMessage = ((String)(message)).split(":");
      double price = Double.parseDouble(theMessage[1]);
      
      if (price < lowPrice) {
        lowPrice = price;
        lowTicker = theMessage[0];
      }
      if (price > highPrice) {
        highPrice = price;
        highTicker = theMessage[0];
      }
      
      if(count == NumberOfTickers) {
        final long end = System.nanoTime();
        System.out.println("High is " + highTicker + " - " + highPrice);
        System.out.println("Low is " + lowTicker + " - " + lowPrice);
        System.out.println("Time " + (end - start) / 1.0e9);
        getContext().stop();        
      }
    }
  }
}
