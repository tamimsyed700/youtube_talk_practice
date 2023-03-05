import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>() { //Not possible in Java 7 or 8
      {
        add(1);
        add(2);
      }
    };
    
    System.out.println(numbers); 
  }
}