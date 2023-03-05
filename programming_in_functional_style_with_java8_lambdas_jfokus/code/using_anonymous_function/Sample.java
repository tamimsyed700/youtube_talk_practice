import java.util.*;

public class Sample { 
  public static void main(String[] args) throws Exception {
    Thread th = new Thread(
      () -> System.out.println("in another thread"));
    
    th.start();
    System.out.println("in main");
    th.join();
    System.out.println("done");
  }
}
