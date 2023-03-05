import java.util.*;

public class Sample {
  public static void process(Object input) {
    var result = switch(input) {
      case Integer i -> " a number";
      case String str -> "a string of length " + str.length();
      default -> "whatever";
    };

    System.out.println("You gave " + result);
  }

  public static void main(String[] args) {
    process(1);
    process("hello");
  }
}

