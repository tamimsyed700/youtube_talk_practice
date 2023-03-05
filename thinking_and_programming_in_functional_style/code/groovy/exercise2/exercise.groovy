//Given a list of names, find the total number of characters. For example, given “John”, “Jack”, “Jill”, “Sam”, “William”, the result should be 22.

def names = ['John', 'Jack', 'Jill', 'Sam', 'William']

println(names.collect { it.length() }.sum() )