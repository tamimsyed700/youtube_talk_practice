import java.util.*;
import java.util.function.Consumer;
import static java.util.stream.Collectors.*;

public class Sample { 
  public static int totalValues(List<Integer> numbers) {
    int result = 0;
    for(int e : numbers) {
      result += e;
    }
    return result;
  }

  public static int totalEvenValues(List<Integer> numbers) {
    int result = 0;
    for(int e : numbers) {
      if(e % 2 == 0) result += e;
    }
    return result;
  }

  public static int totalOddValues(List<Integer> numbers) {
    int result = 0;
    for(int e : numbers) {
      if(e % 2 != 0) result += e;
    }
    return result;
  }
  
  public static void main(String[] args) throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    System.out.println(totalValues(numbers));
    System.out.println(totalEvenValues(numbers));
    System.out.println(totalOddValues(numbers));
  }
}
