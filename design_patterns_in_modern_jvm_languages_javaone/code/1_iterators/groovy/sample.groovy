def numbers = [1, 2, 3, 4, 5, 6]

println "External iterator"
for(number in numbers) { println number }

println "Internal iterator"
numbers.each { println it }

println "First even number"
println numbers.find { it % 2 == 0 }

println "All even numbers"
println numbers.findAll { it % 2 == 0 }

println "Computing total with immutability"
println numbers.inject(0) { total, e -> total + e }

println "The collection we've been using"
println numbers.class