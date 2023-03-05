import java.util.*;
import java.util.function.*;

public class Sample {
  public static double sqrt(int number) {
    System.out.println("sqrt called for " + number);
    return Math.sqrt(number);
  }
  
  public static void main(String[] args) {
    Map<Integer, Double> squareroots = new HashMap<>();
    Function<Integer, Double> sqrtOf = Sample::sqrt;
    
    System.out.println(squareroots.computeIfAbsent(4, sqrtOf));
    System.out.println(squareroots.computeIfAbsent(4, sqrtOf));
  }
}

