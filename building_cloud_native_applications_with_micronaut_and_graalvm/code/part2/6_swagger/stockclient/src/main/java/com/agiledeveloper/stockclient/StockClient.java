package com.agiledeveloper.stockclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Client(id = "stockinfo")
@CircuitBreaker
public interface StockClient {
  @Get("/stocks/{ticker}")
  Mono<Stock> getStock(String ticker);

  @Get("/stocks")
  Flux<Stock> getStocks();
}
