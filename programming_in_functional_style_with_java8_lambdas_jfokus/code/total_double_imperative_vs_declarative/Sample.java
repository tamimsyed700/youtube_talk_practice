import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample { 
  public static void main(String[] args) throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    int totalOfDouble = 0;
    for(int e : numbers) {
      totalOfDouble += e * 2;
    }
    System.out.println(totalOfDouble);

    System.out.println(
      numbers.stream()
             .mapToInt(value -> value * 2)
             .sum());
  }
}
