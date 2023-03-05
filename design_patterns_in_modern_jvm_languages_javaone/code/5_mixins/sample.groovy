class Friend {
  def listen() { println "I'm $name listening..." }
}

@groovy.transform.Immutable
class Human {
  String name
}

Human.mixin Friend

def sam = new Human("Sam")
sam.listen()

@groovy.transform.Immutable
class Dog {
  String name
}

Dog.mixin Friend
def buddy = new Dog("Buddy")
buddy.listen()

@groovy.transform.Immutable
class Cat {
  String name
}

try {
  def alf = new Cat("Alf")  
  alf.listen()
} catch(ex) {
  println "oops, can't can't do that"
}

def oscar = new Cat("Oscar")
oscar.metaClass.mixin Friend
println "Oscar is special"
oscar.listen()