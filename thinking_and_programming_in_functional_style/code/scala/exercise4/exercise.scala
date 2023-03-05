//Given a number, determine the factorial of that number using tail recursion

def factorial(number : Int) = {
  @scala.annotation.tailrec
  def factorialImpl(fact : Int, num : Int) : Int = {
    if (num == 1)
      fact
    else
      factorialImpl(fact * num, num - 1)
  }

  factorialImpl(1, number)  
}

println(factorial(5))