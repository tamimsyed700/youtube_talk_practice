import akka.actor.UntypedActor;

import javax.sound.midi.SysexMessage;

public class PriceKeeper extends UntypedActor {
  int numberOfPricesReceived;
  int totalNumberOfPrices = 0;
  String topStock = "";
  double topStockPrice = 0.0;
  long start;

  @Override
  public void preStart() {
    start = System.nanoTime();
    super.preStart();
  }

  @Override
  public void onReceive(final Object message) throws Exception {
    if(message instanceof Integer) {
      totalNumberOfPrices = ((Integer)(message)).intValue();
    } else {
      numberOfPricesReceived++;
      SymbolAndPrice symbolAndPrice = (SymbolAndPrice) message;

      if(topStockPrice < symbolAndPrice.price) {
        topStockPrice = symbolAndPrice.price;
        topStock = symbolAndPrice.symbol;
      }

      if(numberOfPricesReceived == totalNumberOfPrices) {
        long end = System.nanoTime();

        System.out.println((end - start)/1.0e9);
        System.out.println(topStock);
        System.out.println(topStockPrice);
        getContext().stop();
      }
    }
  }
}
