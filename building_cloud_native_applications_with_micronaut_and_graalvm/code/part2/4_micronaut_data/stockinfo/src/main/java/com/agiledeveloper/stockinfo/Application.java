package com.agiledeveloper.stockinfo;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
    @Inject
    StockService stockService;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        stockService.saveStock(new Stock(null, "ORCL", 80));
        stockService.saveStock(new Stock(null, "MSFT", 180));
        stockService.saveStock(new Stock(null, "GOOG", 1180));
        stockService.saveStock(new Stock(null, "AMZN", 3080));
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
