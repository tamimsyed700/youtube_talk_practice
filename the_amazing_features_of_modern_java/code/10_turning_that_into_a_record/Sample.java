import java.util.*;

record Person(String firstName, String lastName) {}

public class Sample {
  public static void main(String[] args) {
    System.out.println(new Person("Alan", "Turning"));
  }
}

