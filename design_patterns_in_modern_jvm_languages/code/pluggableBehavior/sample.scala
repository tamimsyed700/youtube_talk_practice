//You can pass function to functions quite easily, using function value objects

def totalSelectedValues(numbers : List[Int])(selector : Int => Boolean) = {
  var total = 0
  for(i <- numbers) {
    if (selector(i)) total += i
  }
  total
}

val numbers = List(1, 2, 3, 4, 5)
println(totalSelectedValues(numbers) { e => true }) // total all numbers
                                   
println(totalSelectedValues(numbers) { e => e % 2 == 0}) //total only even numbers
                                   
println(totalSelectedValues(numbers) { e => e % 2 != 0}) //total only odd numbers
                                   
println(totalSelectedValues(numbers) { _ > 4 }) //total only greater than 4 numbers

