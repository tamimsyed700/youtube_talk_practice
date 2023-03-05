import java.util.*;

interface Util {
  default int getNumberOfProcessors() { return getCount(); }
  static int getNumberOfProcessors2() { return getCount2(); }
  
  private int getCount() { return 2; }
  private static int getCount2() { return 2; }
}

public class Sample {  
  public static void main(String[] args) {
    System.out.println("OK");
  }
}