trait Friend {
  def listen(){ println("I'm $name, listening...") }
}

class Human implements Friend {
  String name
  Human(theName) { name = theName }
}

class Dog implements Friend {
  String name
  Dog(theName) { name = theName }
}

class Cat {
  String name
  Cat(theName) { name = theName }
}

def seekHelpFrom(friend) {
  friend.listen()
}

def sam = new Human("Sam")
seekHelpFrom(sam)

def buddy = new Dog("Buddy")
seekHelpFrom(buddy)

def alf = new Cat("Alf")
//seekHelpFrom(alf) //ERROR

def tac = new Cat("Tac") as Friend
seekHelpFrom(tac)
