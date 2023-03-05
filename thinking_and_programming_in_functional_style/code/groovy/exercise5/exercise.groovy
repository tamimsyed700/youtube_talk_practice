//Using memoization, compute the Fibonacci number where Fib(n) = Fib(n-1) + Fib(n-1), and Fib(0) = 0, and Fib(1) = 1.
//Measure the time for non-memoized recursive version and the memoized version.

def fib(number) {
  if (number < 2)
    return number
  else
    return fib(number - 1) + fib(number - 2)
}

cache = [:]

def fibMemoized(number) {
  if (number < 2) return number
  
  if(!cache.containsKey(number))
    cache.put(number, fibMemoized(number -1) + fibMemoized(number - 2))
  cache.get(number)
}

def timeIt(code) {
  def start = System.nanoTime()
  def result = code()
  def end = System.nanoTime()
  println "Time taken ${(end - start)/1.0e9}"
  result
}

println timeIt { fib(40) }
println timeIt { fibMemoized(40) }