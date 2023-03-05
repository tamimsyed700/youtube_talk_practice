val numbers = List(1, 2, 3, 4, 5, 6)

println("External iterator")
for(number <- numbers) { println(number) }

println("Internal iterator")
numbers foreach println

println("First even number")
println(numbers.find { e => e % 2 == 0 })

println("All even numbers")
println(numbers.filter { e => e % 2 == 0 })

println("Computing total with immutability")
println(numbers.foldLeft(0) { (total, e) => total + e })
