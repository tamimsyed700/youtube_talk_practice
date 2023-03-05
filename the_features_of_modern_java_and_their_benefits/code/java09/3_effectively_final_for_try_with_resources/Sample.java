import java.util.*;

class Resource implements AutoCloseable {
  public Resource() { System.out.println("Created..."); }
  public void op1() { System.out.println("op1"); }
  public void op2() { System.out.println("op2"); }
  public void close() { System.out.println("clean up external resources"); }
}

public class Sample {  
  public static void use(Resource resource) {
    
    //try(Resource resource = new Resource()) Java 7 and 8 allowed this
    
    try(resource) { //Was not possible in Java 7 and 8
      resource.op1();
      resource.op2();
    }
  }
  
  public static void main(String[] args) {
    use(new Resource());
  }
}