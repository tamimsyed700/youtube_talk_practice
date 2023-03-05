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

  public static CompletableFuture<String> readFileAsync(
    String pathToFile, ForkJoinPool pool) {

    if(pool != null) {
      return CompletableFuture.supplyAsync(() -> readFile(pathToFile), pool);
    } else {
      return CompletableFuture.supplyAsync(() -> readFile(pathToFile));
    }
  }

  public static int countSize(String text) {
    System.out.println("countSize is running in " + Thread.currentThread());
    return text.length();
  }

  public static void run(ForkJoinPool pool) throws Exception {
    var latch = new CountDownLatch(1);
    readFileAsync("Sample.java", pool)
      .thenApply(Sample::countSize)
      .thenAccept(System.out::println)
      .thenRun(() -> latch.countDown());

    System.out.println("Asked for the file's details");
    System.out.println("we are not blocked, we can do other things we like");
    latch.await(10, TimeUnit.SECONDS);
  }

  public static void main(String[] args) throws Exception {
    run(null);
    System.out.println("-------");
    ForkJoinPool pool = new ForkJoinPool(10);
    run(pool);
    pool.shutdown();
  }
}

