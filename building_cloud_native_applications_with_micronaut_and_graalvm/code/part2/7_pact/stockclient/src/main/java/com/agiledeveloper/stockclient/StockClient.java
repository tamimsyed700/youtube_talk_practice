package com.agiledeveloper.stockclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client(id = "stockclient")
interface StockClient {
  @Get("/stocks/{ticker}")
  Stock getStock(String ticker);
}
