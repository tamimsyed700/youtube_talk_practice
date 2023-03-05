import java.util.*;
import java.util.function.*;
import java.nio.file.*;

public class Sample {                                    
  public static boolean containsJava(String line) {
    return line.contains("java");
  }                              
  
  public static void main(String[] args) throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Files.readString(Path.of("Sample.java"))
      .lines()
      .filter(Predicate.not(Sample::containsJava))
      .forEach(System.out::println);
      
    System.out.println("ho ".repeat(3));
    
    System.out.println("  ".isBlank());
                          
    String str = "     what   is this   ";
    System.out.println(str.strip());
    System.out.println(str.trim());
  }
}