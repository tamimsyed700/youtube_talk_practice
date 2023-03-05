package com.agiledeveloper.stockinfo;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
  @Executable
  Stock find(String ticker);
}
