package com.agiledeveloper.stockinfo;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Provider("stock-info")
@PactFolder("../common/pacts")
@MicronautTest
public class StockInfoContractTest {
  @Inject
  EmbeddedServer server;

  @Inject
  StockService stockService;

  @BeforeEach
  void setupTestTarget(PactVerificationContext context) {
    context.setTarget(new HttpTestTarget(server.getHost(), server.getPort()));

    when(stockService.getstock("GOOG")).thenReturn(Mono.just(new Stock(1L, "GOOG", 1234)));
  }

  @TestTemplate
  @ExtendWith(PactVerificationInvocationContextProvider.class)
  void pactVerificationTestTemplate(PactVerificationContext context) {
    context.verifyInteraction();
  }

  @State("request stock price")
  public void requestStockPrice() {
  }

  @MockBean(StockService.class)
  StockService stockService() {
    return mock(StockService.class);
  }
}
