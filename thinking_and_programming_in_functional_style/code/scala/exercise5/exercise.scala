//Using memoization, compute the Fibonacci number where Fib(n) = Fib(n-1) + Fib(n-1), and Fib(0) = 0, and Fib(1) = 1.
//Measure the time for non-memoized recursive version and the memoized version.

def fib(number : Int) : BigInt = {
  if (number < 2)
    BigInt(number)
  else
    fib(number - 1) + fib(number - 2)
}

def fibMemoized(number : Int) = {
  def fibImpl(cache : List[BigInt], number : Int) : List[BigInt] = {
    number match {
      case _ if cache.size > number => cache
      case _ =>
        val newCache = fibImpl(fibImpl(cache, number - 1), number - 2)
        newCache ::: List(newCache(number - 1) + newCache(number - 2))
    }
  }
  
  fibImpl(List(0, 1), number)(number)
}


def timeIt(code : Unit => BigInt) = {
  val start = System.nanoTime
  val result = code()
  val end = System.nanoTime
  println("Time taken " + ((end - start) / 1.0e9))
  result
}

println(timeIt { Unit => fib(40) })
println(timeIt { Unit => fibMemoized(40) })