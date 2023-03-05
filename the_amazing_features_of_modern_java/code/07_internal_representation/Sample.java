import java.util.*;

public class Sample {
  public static String greet(String city) {
    var message = """
    Hello %s,

    Very glad to see you, hope you're all doing well.      \s
    It is "wonderful" to be here.      

    Thank you for coming...

    Hope you enjoy \
    your time here on %s.
    """;

    return String.format(message, city, new Date());

    //run javac -d bin Sample.java
    //Then view the bytecode using javap
    //javap bin/Sample.class

    //Notice there is no textblock in the bytecode, it is simply a String
  }

  public static void main(String[] args) {
    System.out.println("------");
    System.out.println(greet("Dallas"));
    System.out.println("------");
  }
}
