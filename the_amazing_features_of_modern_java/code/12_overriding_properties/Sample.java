import java.util.*;

record Person(String firstName, String lastName) {
  public String firstName() {
    return firstName.toUpperCase();
  }
}
//constructor
//getter for each property
//toString
//equals
//hashCode

public class Sample {
  public static void main(String[] args) {
    var person1 = new Person("Alan", "Turning");
    var person2 = new Person("Alan", "Turning");
    var person3 = new Person("Mary", "Turning");

    System.out.println(person1.firstName());
    //person1.firstName("Joe"); //ERROR
    //person1.firstName = "Joe"; //ERROR

    System.out.println(person1); //toString()

    System.out.println(person1.equals(person2));
    System.out.println(person1.equals(person3));

    System.out.println(person1.hashCode());
  }
}

