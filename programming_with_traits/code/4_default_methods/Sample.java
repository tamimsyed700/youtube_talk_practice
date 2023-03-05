interface Friend {
  public String getName();
  public default void listen() {
    System.out.println(String.format("I'm %s, listening", getName()));    
  }
}

class Dog implements Friend {
  public final String name;
  public String getName() { return name; }
  public Dog(String theName) { name = theName; }
}

class Human implements Friend {
  public final String name;
  public String getName() { return name; }
  public Human(String theName) { name = theName; }
}

public class Sample {
  public static void seekHelpFrom(Friend friend) {
    friend.listen();
  }
  
  public static void main(String[] args) {
    Human sam = new Human("Sam");
    Dog buddy = new Dog("Buddy");
    
    seekHelpFrom(sam);
    seekHelpFrom(buddy);
  }
}

//That reuses the FriendImpl, but that still leaves some duplication and effort in 
//the two classes.
