import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class Sample {
  public static String readFile(String pathToFile) {
    try {
      System.out.println("readFile is running in " + 
        Thread.currentThread());
      return Files.readString(Paths.get(pathToFile)); 
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static CompletableFuture<String> readFileAsync(String pathToFile) {
    return CompletableFuture.supplyAsync(() -> readFile(pathToFile));
  }

  public static int countSize(String text) {
    System.out.println("countSize is running in " + Thread.currentThread());
    return text.length();
  }

  public static void main(String[] args) throws Exception {
    var latch = new CountDownLatch(1);
    readFileAsync("Sample.java")
      .thenApply(Sample::countSize)
      .thenAccept(System.out::println)
      .thenRun(() -> latch.countDown())
      .thenRun(() -> System.out.println("we are done with the pipeline"))
      .thenRun(() -> System.out.println("we are really done"))
      .thenRun(() -> System.out.println("yes we are"));

    System.out.println("Asked for the file's details");
    System.out.println("we are not blocked, we can do other things we like");
    latch.await(10, TimeUnit.SECONDS);
  }
}

//When one stage finishes a next stage starts

