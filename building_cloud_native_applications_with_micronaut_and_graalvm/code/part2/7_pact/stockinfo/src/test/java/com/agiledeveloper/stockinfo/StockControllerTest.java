package com.agiledeveloper.stockinfo;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class StockControllerTest {
  @Client("/")
  interface StockClient {
    @Get("/{ticker}")
    Stock getStock(String ticker);
  }

  @Inject
  private StockClient stockClient;

  @Test
  void getPriceForORCL(){
    int price = stockClient.getStock("ORCL").getPrice();

    assertEquals(80, price);
  }

}
