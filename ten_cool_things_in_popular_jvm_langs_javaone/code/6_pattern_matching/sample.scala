def process(data : Any) = {
  data match {
    case 1 => println("Got 1")
    case _ : Int => println("Received an int " + data)
    case _ : Double => println("You have sent a double " + data)
    case x : String => println("A string: " + x)
    case List("apple", otherFruits @ _*) => println("fruits: apples and " + otherFruits.mkString(", "))
    case list : List[_] => println("got a list " + list)
    case <hello>{message}</hello> => println("got xml with " + message)
    case _ => println("Received soemthing: " + data)
  }
}

process(1)
process(2)
process(2.2)
process("hello")
process(List(1, 2, 3)) 
process(List("apple", "orange", "banana"))
process("<hello>there</hello>")
process(("some", "stuff"))

/*
Got 1
Received an int 2
You have sent a double 2.2
A string: hello
got a list List(1, 2, 3)
fruits: apples and orange, banana
A string: <hello>there</hello>
Received soemthing: (some,stuff)
*/