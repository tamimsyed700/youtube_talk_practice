package com.agiledeveloper.stockclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;

@Client(id = "stockinfo")
@CircuitBreaker
public interface StockClient {
  @Get("/{ticker}")
  Stock getStock(String ticker);
}
