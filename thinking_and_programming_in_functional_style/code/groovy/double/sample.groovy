def numbers = [1, 2, 3, 4, 5, 6]

// imperative style
def doubled = []

for(number in numbers) {
  doubled << number * 2
}

println "Given $numbers"
println "Doubled $doubled"

// functional style
print "Doubled "
println numbers.collect { it * 2 }