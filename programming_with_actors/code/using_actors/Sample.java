import akka.actor.ActorRef;
import akka.actor.Actors;
import scala.actors.Actor;
import scala.reflect.Symbol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
  public static void main(String[] args) throws InterruptedException {
//    long start = System.nanoTime();
//
//    String topStock = "";
//    double topStockPrice = 0.0;
//    for(String symbol : Stocks.tickers) {
//      double price = YahooFinance.getPrice(symbol);
//      if(topStockPrice < price) {
//        topStockPrice = price;
//        topStock = symbol;
//      }
//    }
//
//    long end = System.nanoTime();
//
//    System.out.println((end - start)/1.0e9);
//    System.out.println(topStock);
//    System.out.println(topStockPrice);

    final ActorRef priceKeeper = Actors.actorOf(PriceKeeper.class).start();

    priceKeeper.sendOneWay(Stocks.tickers.length);

    ExecutorService service = Executors.newFixedThreadPool(100);
    for(final String symbol : Stocks.tickers) {
      service.submit(new Runnable() {
        public void run() {
          SymbolAndPrice symbolAndPrice =
              new SymbolAndPrice(symbol,
                  YahooFinance.getPrice(symbol));

          priceKeeper.sendOneWay(symbolAndPrice);
        }
      });
    }

    service.shutdown();
  }
}