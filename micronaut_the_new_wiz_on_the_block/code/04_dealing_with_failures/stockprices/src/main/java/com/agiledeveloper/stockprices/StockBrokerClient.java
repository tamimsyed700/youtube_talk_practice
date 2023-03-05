package com.agiledeveloper.stockprices;

import io.micronaut.http.client.annotation.*;
import io.micronaut.http.annotation.*;
import com.agiledeveloper.stocks.*;
import io.micronaut.retry.annotation.*;

@Client(id = "stockbroker")
@CircuitBreaker
public interface StockBrokerClient extends StockBrokerRequest {
  @Get("/price/{ticker}")
  public Stock priceFor(String ticker);
}