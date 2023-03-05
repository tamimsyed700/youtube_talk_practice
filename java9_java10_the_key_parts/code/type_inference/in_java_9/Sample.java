import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    //List<Integer> numbers = new ArrayList<Integer>() { //Works in Java 8
    //  {
    //    add(1);
    //    add(2);
    //  }
    //};
    
    List<Integer> numbers = new ArrayList<>() { //Works in Java 9 and up
      {
        add(1);
        add(2);
      }
    };

    System.out.println(numbers);
  }
}