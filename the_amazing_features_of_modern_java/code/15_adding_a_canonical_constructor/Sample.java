import java.util.*;

record Person(String firstName, String lastName) {
  public Person {
    if(firstName.toLowerCase().equals(firstName)) {
      throw new RuntimeException("Name should have mixedcase");
    }
  }
}

public class Sample {
  public static void main(String[] args) {
    var person1 = new Person("alan", "Turning");
    System.out.println(person1);
  }
}

