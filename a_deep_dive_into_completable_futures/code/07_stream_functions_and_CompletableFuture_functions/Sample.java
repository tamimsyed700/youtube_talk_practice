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
    readFileAsync("Sample.java")
      .thenApply(Sample::countSize)
      .thenAccept(System.out::println)
      .thenRun(() -> latch.countDown());

    latch.await(10, TimeUnit.SECONDS);
  }
}

/*
  Stream          Parameter      Abstract method       CompletableFuture
  map             Function       apply                 thenApply
  peek/forEach    Consumer       accept                thenAccept
                  Runnable       run                   thenRun


CompletableFuture's thenApply is much like the map of Stream
CompletableFuture's thenAccept is much like the peek of Stream or
forEach of Stream (except for not being a terminal operation)

*/
