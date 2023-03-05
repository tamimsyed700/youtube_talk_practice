import java.util.*;

public class Sample {
  public static String greet(String city) {
    var message = """
    Hello there,

        Very glad to see you, hope you're all doing well.
    It is "wonderful" to be here.

    Thank you for coming...
    """;

    return message;
  }

  public static void main(String[] args) {
    System.out.println("------");
    System.out.println(greet("Dallas"));
    System.out.println("------");
  }
}
