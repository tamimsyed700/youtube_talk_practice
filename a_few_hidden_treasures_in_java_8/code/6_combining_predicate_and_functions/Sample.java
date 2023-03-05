import java.util.*;
import java.util.function.*;

public class Sample {
  public static void printInfo(int value, String msg, Predicate<Integer> predicate) {
    System.out.println(value + msg + ": " + predicate.test(value));
  }

  public static void printInfo(int value, String msg, Function<Integer, Integer> function) {
    System.out.println(value + msg + ": " + function.apply(value));
  }
  
  public static void main(String[] args) {
    Predicate<Integer> isGT5 = e -> e > 5;
    Predicate<Integer> isEven = e -> e % 2 == 0;
    
    printInfo(4, " is greater than 5 ", isGT5);
    printInfo(4, " is even ", isEven);
    printInfo(4, " is greater than 5 and even", isGT5.and(isEven));
    printInfo(4, " is greater than 5 or even", isGT5.or(isEven));
    
    Function<Integer, Integer> inc = e -> e + 1;
    Function<Integer, Integer> doubled = e -> e * 2;
    
    printInfo(4, " incremented ", inc);
    printInfo(4, " doubled ", doubled);
    printInfo(4, " incremented and doubled ", inc.andThen(doubled));
    printInfo(4, " doubled and incremented ", inc.compose(doubled));
  }
}

