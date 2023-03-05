package com.agiledeveloper.stockclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client(id = "stockclient")
public interface StockClient {
  @Get("/{ticker}")
  Stock getStock(String ticker);
}
