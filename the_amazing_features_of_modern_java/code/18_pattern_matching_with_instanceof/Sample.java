import java.util.*;

public class Sample {
  public static void process(Object input) {
    if(input instanceof Integer) {
      System.out.println("You gave a number");
    }

    /*
    if(input instanceof String) {
      int length = ((String)(input)).length();
      //They called it casting, I call it punishment
      System.out.println("You gave a string of length " + length);
    }
    */

    if(input instanceof String str) {
      System.out.println("You gave a string of length " + str.length());
    }
  }

  public static void main(String[] args) {
    process(1);
    process("hello");
  }
}

