import java.util.*;

public class Sample {  
  //var max = 1000; //not for fields
  
  //public void process(var count) // not for parameters
  
  public static void main(String[] args) throws java.io.IOException {
    var numberOfCores = Runtime.getRuntime().availableProcessors();
    
    System.out.println(numberOfCores);
    
    var names = List.of("Tom", "Jerry");
    
    for(var name: names) {
      System.out.println(name);
    }
    
    try(var reader = new java.io.FileReader("Sample.java")) {
      System.out.println("reading...");
    }
  }
}