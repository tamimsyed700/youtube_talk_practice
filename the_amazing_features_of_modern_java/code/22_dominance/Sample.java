import java.util.*;

public class Sample {
  public static String process(Object input) {
    return switch(input) {
      case Number n -> "a number";
      case Integer i -> "an int";
      case String str -> "a string of length " + str.length();
      default -> "whatever";
    };
  }

  public static void main(String[] args) {
    Arrays.asList(1, "hello")
      .stream()
      .map(Sample::process)
      .forEach(System.out::println);
  }
}

