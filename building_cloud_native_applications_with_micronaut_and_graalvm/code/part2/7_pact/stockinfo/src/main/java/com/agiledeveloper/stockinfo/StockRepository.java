package com.agiledeveloper.stockinfo;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@R2dbcRepository(dialect = Dialect.H2)
public interface StockRepository extends ReactiveStreamsCrudRepository<Stock, Long> {
  Mono<Stock> find(String ticker);

  Flux<Stock> findAll();
}
