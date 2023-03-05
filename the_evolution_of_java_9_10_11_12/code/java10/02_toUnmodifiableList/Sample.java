import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    {
      List<Integer> evens = numbers.stream()
        .filter(e -> e % 2 == 0)
        .collect(toList());

      evens.add(7);
      System.out.println(evens);      
    }                           
    
    List<Integer> evens = numbers.stream()
      .filter(e -> e % 2 == 0)
      .collect(toUnmodifiableList());
      
    //evens.add(7); //Error at runtime 
    //evens.set(0, 7); //Error at runtime
    
    System.out.println(evens);
    System.out.println(evens.getClass());
  }
}