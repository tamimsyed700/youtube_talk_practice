import java.util.*;
import java.util.function.Consumer;

class Resource {
  public Resource() { System.out.println("created..."); }
  public void fn1() { System.out.println("fn1"); }
  public void fn2() { System.out.println("fn2"); }
  public void finalize() { System.out.println("cleanup"); }
}

public class Sample { 
  public static void main(String[] args) {
    Resource resource = new Resource();
    resource.fn1();
    resource.fn2();
    //finalize was never called.
  }
}









