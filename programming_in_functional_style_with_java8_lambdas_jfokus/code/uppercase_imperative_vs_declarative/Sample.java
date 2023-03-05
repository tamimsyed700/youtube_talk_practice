import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample { 
  public static void main(String[] args) throws Exception {
    List<String> names = Arrays.asList("Joe", "Sara", 
      "Jack", "Kim");
    
    List<String> namesInUpperCase = new ArrayList<>();
    for(String name : names) {
      namesInUpperCase.add(name.toUpperCase());
    }
    
    for(int i = 0; i < namesInUpperCase.size(); i++) {
      System.out.print(namesInUpperCase.get(i));
      if(i != namesInUpperCase.size() - 2)
        System.out.print(", ");
    }
    System.out.println("");
    
    //after all of that, that's still wrong and needs fixing.
    
    
    System.out.println(
      names.stream()
           .map(name -> name.toUpperCase())
           .collect(joining(", ")));
  }
}
