import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class Sample {
  public static String readFile(String pathToFile) {
    try {
      return Files.readString(Paths.get(pathToFile)); 
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static CompletableFuture<String> readFileAsync(String pathToFile) {
    return CompletableFuture.supplyAsync(() -> readFile(pathToFile));
  }

  public static int countSize(String text) {
    return text.length();
  }

  public static void main(String[] args) throws Exception {
    var latch = new CountDownLatch(1);
    readFileAsync("ample.java")
      .thenApply(Sample::countSize)
      .thenAccept(System.out::println)
      .exceptionally(throwable -> handleException(throwable))
      .thenRun(() -> latch.countDown());

    System.out.println(latch.await(10, TimeUnit.SECONDS));
  }

  public static Void handleException(Throwable throwable) {
    System.out.println("ERROR: " + throwable.getMessage());
    
    throw new RuntimeException("This is beyound any reasonable repair");
  }
}

//Between the previous example and this one, notice how the latch
//was released vs. not in this one.

