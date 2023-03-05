import java.util.*;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;

public class Sample { 
  public static int totalValues(List<Integer> numbers,
    Predicate<Integer> selector) {
    int result = 0;
    for(int e : numbers) {
      if(selector.test(e)) result += e;
    }
    return result;
  }
  
  public static void main(String[] args) throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    System.out.println(totalValues(numbers, number -> true));
    System.out.println(totalValues(numbers, 
        number -> number % 2 == 0));

    Predicate<Integer> isOdd = (Integer number) -> number % 2 != 0;
    
    System.out.println(totalValues(numbers, isOdd));
  }
}
