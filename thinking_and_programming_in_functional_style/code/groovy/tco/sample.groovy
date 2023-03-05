def f1(a) {
  if (a == 1) throw new RuntimeException("oops")
  
  1 * f1(a - 1)
}

try {
  f1(5)
} catch(all) {
  println all.printStackTrace()
}

println "******** Using trampoline call ************"
def f2 
f2 = { a ->
  if (a == 1) throw new RuntimeException("oops")
  f2.trampoline(a - 1)
}.trampoline()

try {
  f2(5)
} catch(all) {
  println all.printStackTrace()
}