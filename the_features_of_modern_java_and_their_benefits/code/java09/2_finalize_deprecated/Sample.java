import java.util.*;

class Resource {
  public Resource() { System.out.println("Created..."); }
  public void op1() { System.out.println("op1"); }
  public void op2() { System.out.println("op2"); }
  public void finalize() { System.out.println("clean up external resources"); }
  //no guarantee finalize will be called. finalize has been deprecated in Java 9
}

public class Sample {  
  public static void main(String[] args) {
    Resource resource = new Resource();
    
    resource.op1();
    resource.op2();  
  }
}