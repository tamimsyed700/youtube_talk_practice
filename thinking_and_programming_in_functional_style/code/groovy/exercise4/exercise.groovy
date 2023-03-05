//Given a number, determine the factorial of that number using tail recursion

def factorial(number) {
  def factorialImpl

  factorialImpl = { fact, num ->
    if (num == 1)
      return fact
    else
      factorialImpl.trampoline(fact * num, num - 1)
  }.trampoline()

  factorialImpl(1, number)  
}

println factorial(5)