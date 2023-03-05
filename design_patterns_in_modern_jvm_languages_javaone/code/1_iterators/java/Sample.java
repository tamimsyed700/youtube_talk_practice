import java.util.*;

public class Sample {
  public static void main(String[] args) {
    //The sample here is in Java8 which is not released yet, and may change
    
    List<Integer> numbers = 
      Arrays.asList(1, 2, 3, 4, 5, 6);
  
    System.out.println(numbers);
    
    List<Integer> doubled =
      new ArrayList<Integer>();
      
    for(int number : numbers) {
      doubled.add(number * 2);
    }
    
    System.out.println(doubled);
    
    System.out.println(
      numbers.map(e -> e * 2)
    );
  }
}
