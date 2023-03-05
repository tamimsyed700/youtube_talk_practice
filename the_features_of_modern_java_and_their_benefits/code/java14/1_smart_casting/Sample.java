import java.util.*;

public class Sample {
  public static void process(Object input) {
    if(input instanceof Integer) {
      System.out.println("got a number");
    }
    
    if(input instanceof String) { //old way
      String str = (String) input;
      
      System.out.println("got a string of length " + str.length());
    }

    if(input instanceof String str) { //smart casting
      System.out.println("got a string of length " + str.length());
    }
    
    System.out.println(input instanceof String str ? "got a string of length " + str.length() : "");
  }
    
  public static void main(String[] args) {
    process(1);
    process("hello");  
  }
}