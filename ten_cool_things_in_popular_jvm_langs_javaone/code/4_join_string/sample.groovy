def names = ["Jack", "Jill", "Brad", "Jake"]

def upcaseNames = []

for(name in names) {
  upcaseNames << name.toUpperCase()
}

for(int i = 0; i < upcaseNames.size(); i++) {
  print upcaseNames.get(i)
  if(i != names.size() - 1) print ", "
}

println ""

println "---------"

println names.collect { it.toUpperCase() }.join(", ")