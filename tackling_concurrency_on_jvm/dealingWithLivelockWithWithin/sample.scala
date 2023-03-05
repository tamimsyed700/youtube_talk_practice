import scala.actors._
import Actor._

def isPrime(number: Int) : Boolean = {
  if (number == 1) return false
  for(i <- 2 to Math.sqrt(number)) {
    if (number % i == 0) return false
  }                                  
  
  true
}

def countPrimes(lower: Int, upper: Int) = {
  var count = 0
  
  for(i <- lower to upper) {
    if (isPrime(i)) count += 1
  }                           
  
  count
}      
                
val caller = self

for(i <- 0 until 1000) {
  val lower = i * 1000 + 1
  val upper = i * 1000 + 1000

  actor { caller ! countPrimes(lower, upper) }  
}                                  

var count = 0

for(i <- 0 to 1000) {
  receiveWithin(1000) {
    case TIMEOUT => println("timed out!!!")
    case result : Int => count += result
  }
}

println(count)
