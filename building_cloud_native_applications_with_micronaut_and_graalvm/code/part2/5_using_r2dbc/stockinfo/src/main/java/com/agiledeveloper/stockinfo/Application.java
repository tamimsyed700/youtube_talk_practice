package com.agiledeveloper.stockinfo;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
    @Inject
    StockService stockService;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "ORCL", 80)))).block();

        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "MSFT", 180)))).block();

        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "GOOG", 1180)))).block();

        ((Mono<Stock>)(stockService.saveStock(new Stock(null, "AMZN", 3180)))).block();
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
