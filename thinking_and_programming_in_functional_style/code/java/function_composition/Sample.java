import java.util.*;
import java.util.stream.*;

public class Sample {
  
  public static void findHighPriced(Stream<String> symbols) {
    System.out.println(
      symbols.map(StockUtil::getPrice)
      .filter(stockInfo -> StockUtil.isPriceLessThan(stockInfo, 500))
      .reduce(StockUtil::pickHigh)
      .get()
    );
  }
  
  public static void main(String[] args) {
    long start = System.nanoTime();
    List<StockInfo> prices = new ArrayList<>();
    for(String ticker : Tickers.symbols) {
      prices.add(StockUtil.getPrice(ticker));
    }
        
    List<StockInfo> pricedLessThan500 = new ArrayList<>();
    for(StockInfo stockInfo : prices) {
      if(StockUtil.isPriceLessThan(stockInfo, 500))
        pricedLessThan500.add(stockInfo);
    }
    
    StockInfo highPriced = new StockInfo("", 0.0);
    for(StockInfo stockInfo : pricedLessThan500) {
      highPriced = StockUtil.pickHigh(highPriced, stockInfo);
    }
    
    System.out.println(highPriced);
    long end = System.nanoTime();
    System.out.println("Time taken for imperative: " + (end - start)/1.0e9);

    start = System.nanoTime();
    findHighPriced(Tickers.symbols.stream());
    end = System.nanoTime();
    System.out.println("Time taken for functional: " + (end - start)/1.0e9);

    start = System.nanoTime();
    findHighPriced(Tickers.symbols.parallelStream());
    end = System.nanoTime();
    System.out.println("Time taken for parallel: " + (end - start)/1.0e9);
  }
}
