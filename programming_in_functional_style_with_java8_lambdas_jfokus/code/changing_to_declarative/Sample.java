import java.util.*;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;

public class Sample { 
  public static int totalValues(List<Integer> numbers,
    Predicate<Integer> selector) {
    return numbers.stream()
                  .filter(selector)
                  .reduce(0, (op1, op2) -> op1 + op2);
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
