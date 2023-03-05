import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list1Copy = List.copyOf(list1);
    
    System.out.println(list1Copy);
    System.out.println(list1.equals(list1Copy));
    System.out.println(list1 == list1Copy);
    System.out.println(list1Copy.getClass());

    List<Integer> list2 = List.of(1, 2, 3);
    List<Integer> list2Copy = List.copyOf(list2);
    
    System.out.println(list2Copy);
    System.out.println(list2.equals(list2Copy));
    System.out.println(list2 == list2Copy);
    System.out.println(list1Copy.getClass());
  }
}