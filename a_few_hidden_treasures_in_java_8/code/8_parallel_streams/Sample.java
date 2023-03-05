import java.util.*;
import java.util.concurrent.*;

public class Sample {
  public static int doubleIt(int number) {
    try { Thread.sleep(1000); } catch(Exception ex) {}
    System.out.println("doubleIt called for " + number);
    return number * 2;
  }

  //1.
  //Compile and run this as is first. Notice the message being printed in a few bursts.
  //The number of bursts will be equal to 20 / perceived number of cores.
  //That's because the 20 values have to be scheduled in the available pool.
  
  //2. The run with the following JVM option
  //-Djava.util.concurrent.ForkJoinPool.common.parallelism=100
  //like
  //java -Djava.util.concurrent.ForkJoinPool.common.parallelism=100 Sample   
  //The number of bursts will be one since all the values were run at the same time in a bigger pool.
  
  //3. change useForkJoin to true instead of false. Then run without the option mentioned in 2 above.
  
  public static void main(String[] args) throws InterruptedException {
    boolean useForkJoin = false;
    
    if(useForkJoin) {
      ForkJoinPool pool = new ForkJoinPool(50);
      
      pool.submit(Sample::run);
      
      pool.shutdown();
      pool.awaitTermination(1, TimeUnit.MINUTES);
    } else {
      run();
    }
  }
  
  public static void run() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

    numbers.parallelStream()
           .map(Sample::doubleIt)
           .reduce(0, Integer::sum);    
  }
}

