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
      .exceptionally(throwable -> handleException(throwable)) 
      .thenApply(Sample::countSize)
      .thenAccept(System.out::println)
      .exceptionally(Sample::printError)
      .thenRun(() -> latch.countDown());


    System.out.println(latch.await(10, TimeUnit.SECONDS));
  }

  public static String handleException(Throwable throwable) {
    System.out.println("ERROR: " + throwable.getMessage());
    System.out.println("this is like switching to another service, etc.");
   
    if(Math.random() > 0.5) {
      System.out.println("do not provide an alternative");
      throw new RuntimeException("Sorry dude");
    } else {
      System.out.println("provide an alternative");
      return readFile("Sample.java");
    }
  }

  public static Void printError(Throwable throwable) {
    System.out.println("ERROR: " + throwable);
    throw new RuntimeException("I quit");
  }
}

//Between the previous example and this one, notice how the latch
//was released vs. not in this one.

