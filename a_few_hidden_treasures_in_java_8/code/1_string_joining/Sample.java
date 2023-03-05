import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import java.io.*;

public class Sample {
  public static void main(String[] args) throws IOException {
    File dir = new File("/Users/venkats/tmp/dir");
    
    File[] children = dir.listFiles();
    
    if(children != null) {
      for(int i = 0; i < children.length; i++) {
        System.out.print(children[i].getName());
        if(i != children.length - 1)
          System.out.print(", ");
      }
      System.out.println();
    }
    
    System.out.println(
      Stream.of(children)
            .map(File::getName)
            .collect(joining(", ")));
  }
}
