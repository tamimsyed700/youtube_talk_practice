import java.util.*;
import java.util.concurrent.*;

public class Sample {
  public static CompletableFuture<Integer> create(int number) {
    var completableFuture = new CompletableFuture<Integer>();

    completableFuture.thenApply(data -> data + 1)
      .thenAccept(System.out::println);

    if(number == 200) {
      System.out.println("if taking too long, let me complete for you");
      completableFuture.completeOnTimeout(7, 5, TimeUnit.SECONDS);
    }

    if(number == 300) {
      System.out.println("if taking too long, timeout");
      completableFuture.orTimeout(5, TimeUnit.SECONDS);
    }
   
    return completableFuture;
  }

  public static void run(int number) {
    CompletableFuture<Integer> completableFuture = create(number);

    if(number < 100) {
      completableFuture.complete(number);
    }
  }

  public static void main(String[] args) throws Exception {
    run(10);
    System.out.println("------");
    run(100); //This is never going to complete.
    System.out.println("------");
    run(200); //This is never going to complete.
    System.out.println("------");
    run(300); //This is never going to complete.
    System.out.println("------");

    Thread.sleep(3000);
  }
}
