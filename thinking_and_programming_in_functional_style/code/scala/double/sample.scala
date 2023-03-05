val numbers = List(1, 2, 3, 4, 5, 6)

// imperative style
var doubled : List[Int] = List()

for(number <- numbers) {
  doubled = doubled ::: List(number * 2)
}

println("Given " + numbers)
println("Doubled " + doubled)

// functional style
print("Doubled ")
println(numbers.map { _ * 2 })