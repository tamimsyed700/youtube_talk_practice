//YahooFinance.java
package com.agiledeveloper;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class YahooFinance {
  private static Random rand = new Random();

  public static double getPrice(final String ticker) {
    try {
      final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);

      final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

      reader.readLine();
      final String data = reader.readLine();
      final String[] dataItems = data.split(",");
      return Double.parseDouble(dataItems[dataItems.length - 1]);      
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
  public static double getPriceMock(final String ticker) {
    //If you run into trouble with wireless connection, use this instead.
    return rand.nextDouble() * 1000;
  }
}
