import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample { 
  public static void main(String[] args) throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    List<Integer> doubled = new ArrayList<>();
    for(int e : numbers) {
      doubled.add(e * 2);
    }
    System.out.println(doubled);
    
    System.out.println(
      numbers.stream()
             .map(value -> value * 2)
             .collect(toList()));
  }
}
