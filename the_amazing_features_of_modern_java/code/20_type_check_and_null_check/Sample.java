import java.util.*;

public class Sample {
  public static String process(Object input) {
    return switch(input) {
      case null -> "null is a smell";
      case Integer i -> " a number";
      case String str -> "a string of length " + str.length();
      default -> "whatever";
    };
  }

  public static void main(String[] args) {
    Arrays.asList(1, null, "hello")
      .stream()
      .map(Sample::process)
      .forEach(System.out::println);
  }
}

