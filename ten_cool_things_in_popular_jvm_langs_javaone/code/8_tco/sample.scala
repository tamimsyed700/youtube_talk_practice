def factorial1(number: Int) : Int = {
  if (number == 1)
    number
  else
    number * factorial1(number - 1)
}

println(factorial1(5)) // recursion is cool, but can result in StackOverflowException for large value of the parameter

//Tail recursion convert the recursion into iteration under the covers and don't have that problem.

def factorial2(number : Int) = {
  @scala.annotation.tailrec
  def factorialImpl(fact : Int, number : Int) : Int = {
    if (number == 1)
      fact
    else
      factorialImpl(fact * number, number - 1)
  }
  
  factorialImpl(1, number)
}

println(factorial2(5))

//120
//120