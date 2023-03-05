import java.util.*;

public class Sample {
  public static String greet(String city) {
    var message = """
    Hello there,

    Very glad to see you, hope you're all doing well.      \s
    It is "wonderful" to be here.      

    Thank you for coming...

    Hope you enjoy \
    your time here.
    """;

    return message.replaceAll(" ", "~");
  }

  public static void main(String[] args) {
    System.out.println("------");
    System.out.println("we can ask for the space to be kept");
    System.out.println(greet("Dallas"));
    System.out.println("------");
  }
}
