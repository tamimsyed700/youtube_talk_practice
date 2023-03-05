import java.util.*;
import java.util.concurrent.*;

public class Sample {
  public static CompletableFuture<Integer> create(int number) {
    return CompletableFuture.supplyAsync(() -> number);
  }

  public static void main(String[] args) throws Exception {
    create(1)
      .thenApply(data -> create(data * 10)) //take data from previous stage and pass it on to another asyn computation 
      .thenAccept(System.out::println);

    System.out.println("--------");
    create(1)
      .thenCompose(data -> create(data * 10)) //take data from previous stage and pass it on to another asyn computation 
      .thenAccept(System.out::println);
  }
}
