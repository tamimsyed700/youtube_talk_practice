trait Friend {
  val name : String //emphasizes the class you mix in should have this
  def listen = println("I'm " + name + " listening...")
}

class Human(val name : String) extends Friend

def seekHelpFrom(friend : Friend) = friend.listen

val peter = new Human("Peter")
peter.listen
seekHelpFrom(peter)

class Animal(val name : String)
class Dog(override val name : String) extends Animal(name) with Friend

val rover = new Dog("Rover")
rover.listen
seekHelpFrom(rover)

class Cat(override val name : String) extends Animal(name)

val alf = new Cat("Alf")
//alf.listen  // Nope
//seekHelpFrom(alf) // Nope

//But you protest, your cat is a friend, OK, let's then selectively allow

val yourSweetCat = new Cat("Garfield") with Friend

yourSweetCat.listen
seekHelpFrom(yourSweetCat)