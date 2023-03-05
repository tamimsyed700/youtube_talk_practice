import java.util.*;
import java.util.Comparator;
import static java.util.Comparator.*;

public class Sample {
  public static List<Person> createPeople() {
    return Arrays.asList(
	    new Person("Sara", Gender.FEMALE, 20),
	    new Person("Sara", Gender.FEMALE, 22),
	    new Person("Bob", Gender.MALE, 20),
	    new Person("Paula", Gender.FEMALE, 32),
	    new Person("Paul", Gender.MALE, 32),
	    new Person("Jack", Gender.MALE, 2),
	    new Person("Jack", Gender.MALE, 72),
	    new Person("Jill", Gender.FEMALE, 12)
	  );
  }

  public static void printSorted(List<Person> people, Comparator<Person> comparator) {
    System.out.println("----------");
    people.stream()
          .sorted(comparator)
          .forEach(System.out::println);
  }
  
  public static void main(String[] args) {
    List<Person> people = createPeople();
    
    printSorted(people, comparing(Person::getName));

    printSorted(people, comparing(Person::getAge));

    printSorted(people, comparing(Person::getAge).thenComparing(Person::getName));
  }
}
