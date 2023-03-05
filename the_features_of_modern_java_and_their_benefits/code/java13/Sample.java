import java.util.*;

public class Sample {  
  public static String createMessage(String name, int numberOfItems) {
    var message = """
    Dear %s
    
    We are very happy to let you know that the %d items you have ordered
    have been shipped on %s.
    
        Thank you for your business.
    """;
    
    return String.format(message, name, numberOfItems, new Date());
  }
  
  public static void main(String[] args) {
    var message = createMessage("Sam", 12);
    
    System.out.println(message);  
  }
}