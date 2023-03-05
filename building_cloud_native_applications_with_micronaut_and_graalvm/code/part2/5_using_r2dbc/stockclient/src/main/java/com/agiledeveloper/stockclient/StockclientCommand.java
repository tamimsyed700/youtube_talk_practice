package com.agiledeveloper.stockclient;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Command(name = "stockclient", description = "...",
        mixinStandardHelpOptions = true)
public class StockclientCommand implements Runnable {
    @Inject
    private StockClient stockClient;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(StockclientCommand.class, args);
    }

    private CountDownLatch latch = new CountDownLatch(2);

    public void run() {
        stockClient.getStocks()
          .subscribe(System.out::println, System.out::println, () -> latch.countDown());

        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
