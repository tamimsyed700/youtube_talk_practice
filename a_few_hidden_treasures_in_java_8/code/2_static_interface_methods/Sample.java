import java.util.*;

interface Util {
  public static int numberOfCores() {
    return Runtime.getRuntime().availableProcessors();
  }
}

public class Sample {
  public static void main(String[] args) {
    System.out.println(Util.numberOfCores());
  }
}
