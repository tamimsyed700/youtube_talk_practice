interface Friendable {
  void listen();
}

class Dog implements Friendable {
  public final String name;
  public Dog(String theName) { name = theName; }
  public void listen() {
    System.out.println(String.format("I'm %s, listening", name));
  }  
}

class Human implements Friendable {
  public final String name;
  public Human(String theName) { name = theName; }
  public void listen() {
    System.out.println(String.format("I'm %s, listening", name));
  }
}

public class Sample {
  public static void seekHelpFrom(Friendable friend) {
    friend.listen();
  }
  
  public static void main(String[] args) {
    Human sam = new Human("Sam");
    Dog buddy = new Dog("Buddy");
    
    seekHelpFrom(sam);
    seekHelpFrom(buddy);
  }
}

//OK that solved some of the problem
//but we have duplicated implementation

//how to fix that?
