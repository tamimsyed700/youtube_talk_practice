//Given a list of names, produce a list of tuples with names and size of each name.
//For example, given “John”, “Jack”, “Jill”, “Sam”, “William”, the result should be
//the list (“John”, 4), (“Jack, 4), (“Jill”, 4), (“Sam”, 3), (“William, 7).

def names = ['John', 'Jack', 'Jill', 'Sam', 'William']

println names.collect { [it, it.length()] }