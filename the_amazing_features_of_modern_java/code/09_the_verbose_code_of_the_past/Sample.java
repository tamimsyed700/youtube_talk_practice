import java.util.*;

class Person {
  private final String firstName;
  private final String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  //let me write the getter...
}

public class Sample {
  public static void main(String[] args) {
    System.out.println(new Person("Alan", "Turning"));
    //The code is verbose, took some effort to write, or we needed a 
    //nice IDE, and after all that, the output still is not good enough.
    
    //now we start writing toString, and if we write an equals, better remember
    //to write a hashCode,...
  }
}

