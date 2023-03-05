interface Friendable {
  void listen();
}

class FriendImpl {
  public void listen(String name) {
    System.out.println(String.format("I'm %s, listening", name));    
  }
}

class Dog implements Friendable {
  public final String name;
  public Dog(String theName) { name = theName; }
  FriendImpl friend = new FriendImpl();

  public void listen() {
    friend.listen(name);
  }  
}

class Human implements Friendable {
  public final String name;
  public Human(String theName) { name = theName; }

  FriendImpl friend = new FriendImpl();

  public void listen() {
    friend.listen(name);
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

//That reuses the FriendImpl, but that still leaves some duplication and effort in 
//the two classes.
