import java.util.*;

interface Util {
  default int getNumberOfCores() {
    return getNumberOfCoresFromRuntime();
  }        
                                             
  //may be called from default methods
  private int getNumberOfCoresFromRuntime() {
    return Runtime.getRuntime().availableProcessors();
  }
  
  static int getCoresCount() {
    return getRuntime().availableProcessors();
  }                                           
                                       
  //may be called from static methods
  private static Runtime getRuntime() {
    return Runtime.getRuntime();
  }
}

public class Sample implements Util {  
  public static void main(String[] args) {
    System.out.println(new Sample().getNumberOfCores());
    
    System.out.println(Util.getCoresCount());
  }
}

