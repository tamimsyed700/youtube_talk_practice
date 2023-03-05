import java.util.*;

public class Sample {    
  public static void process(Optional<Integer> result) {
    System.out.println(result);
    
    //System.out.println(result.get()); //bad idea                              
    
    System.out.println(result.orElseThrow());
    
    System.out.println("----------");
  }
  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    process(numbers.stream()
      .filter(e -> e > 5)
      .findFirst());

    process(numbers.stream()
      .filter(e -> e > 50)
      .findFirst());
  }
}