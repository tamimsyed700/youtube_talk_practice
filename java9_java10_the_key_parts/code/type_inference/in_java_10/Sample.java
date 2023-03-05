import java.util.*;
import static java.util.stream.Collectors.*;

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

  public static void main(String[] args) {
    //Type inference for local variables
    // not for fields, not for parameters, not for lambdas
    
    var numbers = List.of(1, 2, 3);
    
    System.out.println(numbers);
    
    var byAge = createPeople().stream()
      .collect(groupingBy(Person::getAge, mapping(person -> (Cloneable) person, toList())));
      
    System.out.println(byAge);                                                              
    
    var firstOfAge20 = byAge.get(20).get(0);
    
    System.out.println(firstOfAge20); //What's the type of firstOfAge20?
    
    //System.out.println(firstOfAge20.getName()); //Not a method on Clonable
    
    //If we remove (Clonable) from line 27, and then uncomment above line, it will work.
  }
}