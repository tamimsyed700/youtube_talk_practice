import java.util.*;

public class Sample {
  public static boolean isEven(int number) {
    return number % 2 == 0;
  }

  public static int doubleIt(int number) {
    return number * 2;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    var result = numbers.stream()
      .filter(Sample::isEven)
      .mapToInt(Sample::doubleIt)
      .sum();

    System.out.println(result);
  }
}

