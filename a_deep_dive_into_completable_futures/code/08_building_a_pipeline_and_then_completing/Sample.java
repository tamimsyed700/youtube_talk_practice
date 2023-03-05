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

  public static void readFileAsync(String pathToFile,
    CompletableFuture<String> pipeline) {

    //We may get data from a file, remote service, a microservice,
    //a database, etc. and then push it on to a given pipeline

    pipeline.complete(readFile(pathToFile));
  }

  public static int countSize(String text) {
    return text.length();
  }

  public static CompletableFuture<String> buildPipeline(CountDownLatch latch) {
    CompletableFuture<String> completableFuture = new CompletableFuture<>();

    completableFuture
      .thenApply(Sample::countSize)
      .thenAccept(System.out::println)
      .thenRun(() -> latch.countDown());
  
    return completableFuture;
  }

  public static void main(String[] args) throws Exception {
    var latch = new CountDownLatch(1);

    readFileAsync("Sample.java", buildPipeline(latch));

    latch.await(10, TimeUnit.SECONDS);
  }
}

