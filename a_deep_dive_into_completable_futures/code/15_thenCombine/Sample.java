import java.util.*;
import java.util.concurrent.*;

public class Sample {
  public static CompletableFuture<Integer> create(int number) {
    return CompletableFuture.supplyAsync(() -> number);
  }

  public static void main(String[] args) throws Exception {
    CompletableFuture<Integer> cf1 = create(1);
    CompletableFuture<Integer> cf2 = create(2);

    cf1.thenCombine(cf2, (result1, result2) -> result1 + result2)
      .thenAccept(System.out::println);

    //Wait for both to complete and then combine the result
    //and produce a promise for the next stage.
  }
}
