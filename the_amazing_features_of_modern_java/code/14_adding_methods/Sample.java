import java.util.*;

//A record can't extends a class, it already extends java.lang.Record
//records are final
record Person(String firstName, String lastName) implements Runnable {
  public void run() {
    System.out.println("running...");
  }

  public String getFullName() {
    return String.format("%s, %s %s", lastName, firstName, lastName);
  }
}

public class Sample {
  public static void main(String[] args) {
    var person1 = new Person("Alan", "Turning");
    System.out.println(person1);
    System.out.println(person1.getFullName());
  }
}

