def f1(a : Int) : Int = {
  if (a == 1) throw new RuntimeException("oops")
  
  1 * f1(a - 1)
}

try {
  f1(5)
} catch {
  case ex => println(ex.printStackTrace)
}

println("********** using tail recursion *************")

@scala.annotation.tailrec
def f2(a : Int) : Int = {
  if (a == 1) throw new RuntimeException("oops")
  
  f2(a - 1)
}

try {
  f2(5)
} catch {
  case ex => println(ex.printStackTrace)
}
