val numbers = List(1, 2, 3, 4, 5, 6)

// imperative style
var total = 0

for(number <- numbers) {
  total += number
}

println("Given " + numbers)
println("Total " + total)

// functional style
print("Total ")
println(numbers.foldLeft(0) { (s, e) => s + e })

print("Total ")
println(numbers.reduce { (e1, e2) => e1 + e2 })

println ("Total " + numbers.sum)