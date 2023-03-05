package com.agiledeveloper.stockclient;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import javax.inject.Inject;

@Command(name = "stockclient", description = "...",
        mixinStandardHelpOptions = true)
public class StockclientCommand implements Runnable {

    @Inject
    private StockClient stockClient;

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(StockclientCommand.class, args);
    }

    public void run() {
        System.out.println(stockClient.getStock("ORCL"));
        System.out.println(stockClient.getStock("MSFT"));
    }
}
