abstract class Writer {
  def write(msg : String)
}

class StringWriter extends Writer {
  val target = new StringBuilder
  
  override def write(msg : String) = target.append(msg)
  override def toString = target.toString
}

def writeStuff(writer : Writer) = {
  writer write "This is stupid"
  println(writer)
}

writeStuff(new StringWriter)

trait UpperCaseFilter extends Writer {
  abstract override def write(msg : String) = super.write(msg.toUpperCase)
}

writeStuff(new StringWriter with UpperCaseFilter)


trait ProfanityFilter extends Writer {
  abstract override def write(msg : String) = super.write(msg.replace("stupid", "s*****"))
}

writeStuff(new StringWriter with ProfanityFilter)

writeStuff(new StringWriter with UpperCaseFilter with ProfanityFilter)

writeStuff(new StringWriter with ProfanityFilter with UpperCaseFilter)

