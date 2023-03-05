import java.util.*;
import javax.validation.constraints.*;

public class Sample {  
  public static void main(String[] args) {
    var numbers = List.of(1, 2, 3);
    
    numbers.forEach((final Integer e) -> System.out.println(e));
    System.out.println("----------");  

    numbers.forEach((@NotNull Integer e) -> System.out.println(e));
    System.out.println("----------");  

    //numbers.forEach((final e) -> System.out.println(e)); //ERROR
    //numbers.forEach((@NotNull e) -> System.out.println(e)); //ERROR

    numbers.forEach((final var e) -> System.out.println(e));
    System.out.println("----------");  

    numbers.forEach((@NotNull var e) -> System.out.println(e));
    System.out.println("----------");
    
    numbers.stream()
      //.reduce(0, (var total, e) -> total + e); //ERROR
      //.reduce(0, (var total, Integer e) -> total + e); //ERROR
      .reduce(0, (var total, var e) -> total + e); //var is redundant here, please don't use it
  }
}