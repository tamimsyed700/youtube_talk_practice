class Human {
  public final String name;
  public Human(String theName) { name = theName; }
  public void listen() {
    System.out.println(String.format("I'm %s, listening", name));
  }
}

public class Sample {
  public static void seekHelpFrom(Human friend) {
    friend.listen();
  }

  public static void main(String[] args) {
    Human sam = new Human("Sam");
    
    seekHelpFrom(sam);
  }
}

//Is listen an intrinsic function of Human?
//Who listens?
//A friend. What about friends other than Human, like Dog?

//We can't inherit Dog from Human to get this method.
//Solution?...
