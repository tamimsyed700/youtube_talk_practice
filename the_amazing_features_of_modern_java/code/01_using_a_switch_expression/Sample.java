import java.util.*;

public class Sample {
  public static String twoOrThree() {
    return "two or three";
  }

  public static String process(int input) {
    var result = switch(input) {
      case 1 -> "one";
      case 2, 3 -> "two or three";
      //case 2, 3 -> twoOrThree();
      case 5 -> {
        System.out.println("doing some work for the value 5");
	//...
	yield "five";
      }
      default -> "whatever";
    };

    return "The given value is " + result;
  }

  public static void main(String[] args) {
    System.out.println(process(1));
    System.out.println(process(2));
    System.out.println(process(3));
    System.out.println(process(4));
    System.out.println(process(5));
  }
}
