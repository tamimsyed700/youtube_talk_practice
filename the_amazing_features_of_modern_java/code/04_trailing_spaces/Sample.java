import java.util.*;

public class Sample {
  //We have blank space on different lines in the text blow
  public static String greet(String city) {
    var message = """
    Hello there,

    Very glad to see you, hope you're all doing well.      
    It is "wonderful" to be here.      

    Thank you for coming...
    """;

    return message.replaceAll(" ", "~");
  }

  public static void main(String[] args) {
    System.out.println("------");
    System.out.println("blank spaces at the end of lines have been removed");
    System.out.println(greet("Dallas"));
    System.out.println("------");
  }
}
