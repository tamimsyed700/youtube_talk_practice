import java.util.*;

public class Sample { 
  public static void main(String[] args) throws Exception {
    List<String> names = Arrays.asList("Joe", "Jake", "Kim", "Sara");
    
    boolean found = false;
    for(String name : names) {
      if(name.equals("Kim")) {
        found = true;
        break;
      }
    }
    System.out.println("Found?: " + found);
    //primitive obsession
    
    System.out.println("Found?: " + names.contains("Kim"));
    
    //Michael Feathers
    //in OO we encapsulate the moving parts
    //in FP we eliminate the moving parts
  }
}
