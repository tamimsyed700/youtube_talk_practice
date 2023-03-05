import java.util.*;
import java.util.function.Function;

class Resource {
  private Resource() { System.out.println("created..."); }
  public void fn1() { System.out.println("fn1"); }
  public int fn2() { System.out.println("fn2"); return 2; }
  private void close() { System.out.println("cleanup"); }
  
  public static int use(Function<Resource, Integer> block) {
    Resource resource = new Resource();
    try {
      return block.apply(resource);
    } finally {
      resource.close();
    }
  }
}

public class Sample { 
  public static void main(String[] args) {
    int result = Resource.use(resource -> {
      resource.fn1();
      return resource.fn2();            
    });
    
    System.out.println(result);
  }
}









