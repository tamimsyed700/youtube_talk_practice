import java.util.*;

class Resource implements AutoCloseable {
  public Resource() { System.out.println("creating expensive resource"); }
  public void op1() { System.out.println("operation 1"); }
  public void op2() { System.out.println("operation 2"); }
  public void close() { System.out.println("clean up"); }
}

public class Sample {
  public static void forgotToCleanup() {
    System.out.println("This method forgets to cleanup expensive resource");
    Resource resource = new Resource();
    resource.op1();
    resource.op2();
  }

  public static void troubleIfThereisAnException() {
    System.out.println("What if exception is thrown?");
    Resource resource = new Resource();
    resource.op1();
    resource.op2(); //close will not be called if this blows up.
    resource.close();
  }
  
  public static void tooVerbose() {
    System.out.println("Too much work, error prone");
    Resource resource = new Resource();

    try {
      resource.op1();
      resource.op2();      
    } finally {
      resource.close();
    }
  }
  
  public static void usingARM() {
    //ARM in Java 7 - still requires programmer to remember to use a try.
    System.out.println("ARM still requires us to remember");
    try(Resource resource = new Resource()) {
      resource.op1();
      resource.op2();
    }
  }
  
  public static void usingEAM() {
    System.out.println("There nothing here to forget");
    MyResource.use(resource -> {
      resource.op1();
      resource.op2();      
    });
  }
  
  public static void main(String[] args) {
    forgotToCleanup();
    troubleIfThereisAnException();
    tooVerbose();
    usingARM();
    usingEAM();
  }
}

//Using EAM
interface UseMyResource {
  public void apply(MyResource resource);
}

class MyResource {
  private MyResource() { System.out.println("creating expensive resource"); }
  public void op1() { System.out.println("operation 1"); }
  public void op2() { System.out.println("operation 2"); }
  private void close() { System.out.println("clean up"); }
  
  public static void use(UseMyResource closure) {
    MyResource resource = new MyResource();
    try {
      closure.apply(resource);
    } finally {
      resource.close();
    }
  }
}
