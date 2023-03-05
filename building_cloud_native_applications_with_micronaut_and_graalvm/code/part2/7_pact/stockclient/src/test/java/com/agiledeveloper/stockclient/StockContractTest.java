package com.agiledeveloper.stockclient;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "stock-info", port = "8080")
public class StockContractTest {
  @Inject
  StockClient stockClient;

  @Pact(consumer = "stock-consumer")
  public RequestResponsePact pactReceiveStockPrice(PactDslWithProvider builder) {
    return builder.given("request stock price")
      .uponReceiving("A ticker symbol")
      .path("/stocks/GOOG")
      .method("GET")
      .willRespondWith()
      .status(200)
      .headers(Map.of("Content-Type", "application/json"))
      .body("{\"id\": 1, \"ticker\": \"GOOG\", \"price\": 1234 }")
      .toPact();
  }

  @PactTestFor(pactMethod = "pactReceiveStockPrice")
  @Test
  public void testGetStockPrice() {
    Stock stock = stockClient.getStock("GOOG");

    assertEquals("GOOG", stock.getTicker());
    assertEquals(1234, stock.getPrice());
  }
}
