import akka.actor.TypedActor;

public class CollectorImpl extends TypedActor implements Collector {
  private int _numberOfItems = 1000;

  public int getNumberOfItems() {
    return _numberOfItems;
  }

  public void sellItems(int number) {
    System.out.println("selling...");
    _numberOfItems -= number;
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("sold...");
  }

  public void buyItems(int number) {
    System.out.println("buying...");
    _numberOfItems += number;
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("bought...");
  }
}
