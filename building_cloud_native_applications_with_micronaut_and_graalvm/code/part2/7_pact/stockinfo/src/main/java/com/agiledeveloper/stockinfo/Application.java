package com.agiledeveloper.stockinfo;

import io.micronaut.context.EnvironmentConfigurable;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(info = @Info(title = "stockinfo", version = "0.0"))
@Singleton
@Requires(notEnv = Environment.TEST)
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
