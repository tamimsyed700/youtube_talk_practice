package com.agiledeveloper.stockbroker;

import io.micronaut.http.client.annotation.*;
import io.micronaut.http.annotation.*;
import com.agiledeveloper.stocks.*;

@Client("/")
public interface StockBrokerClient extends StockBrokerRequest {
  @Get("/price/{ticker}")
  public Stock priceFor(String ticker);
}