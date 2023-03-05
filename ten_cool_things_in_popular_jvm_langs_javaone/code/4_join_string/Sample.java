import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Jack", "Jill", "Brad", "Jake");
    System.out.println(
      names.stream().map(String::toUpperCase).collect(joining(", ")));
  }
}