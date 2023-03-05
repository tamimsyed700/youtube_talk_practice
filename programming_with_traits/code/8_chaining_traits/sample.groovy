class StringWriter {
  def target = new StringBuilder()
  def write(msg) {
    target.append(msg)
  }
  String toString() { target.toString() }
}

def writeStuff(writer) {
  writer.write("This is stupid")
  println writer
}

trait UppercaseFilter {
  def write(msg) {
    def text = msg.toUpperCase()
    super.write(text)
  }
  String toString() { super.toString() }
}

trait ProfanityFilter {
  def write(msg) {
    def text = msg.replace("stupid", "*****")
    super.write(text)
  }
  String toString() { super.toString() }
}

writeStuff(new StringWriter())
writeStuff(new StringWriter() as UppercaseFilter)
writeStuff(new StringWriter() as ProfanityFilter)
def inst = new StringWriter().withTraits UppercaseFilter, ProfanityFilter 
writeStuff(inst)


