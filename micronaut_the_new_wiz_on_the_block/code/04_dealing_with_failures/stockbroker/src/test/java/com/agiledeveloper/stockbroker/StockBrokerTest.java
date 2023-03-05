package com.agiledeveloper.stockbroker;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import io.micronaut.test.annotation.*; 
import javax.inject.Inject;
import com.agiledeveloper.stocks.Stock;
  
@MicronautTest
public class StockBrokerTest {
  @Inject
  StockBrokerClient stockBrokerClient;
  
  @Test
  void canary() {
    assertTrue(true);
  }
  
  @Test
  void getPriceFor() {
    Stock stock = stockBrokerClient.priceFor("GOOG");
    
    assertEquals("GOOG", stock.getTicker());
    assertTrue(stock.getPrice() >= 0);
  }
}