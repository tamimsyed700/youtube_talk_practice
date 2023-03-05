def numbers = [1, 2, 3, 4, 5, 6]

// imperative style
def total = 0

for(number in numbers) {
  total += number
}

println "Given $numbers"
println "Total $total"

// functional style
print "Total "
println numbers.inject(0) { s, e -> s + e }

println "Total ${numbers.sum() }"