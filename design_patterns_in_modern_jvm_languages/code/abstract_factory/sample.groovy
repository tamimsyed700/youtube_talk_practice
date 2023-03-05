class Book {
  def title
  def pages
}

class CD {
  def title
  def volume
}

def createInstance(klass, properties) {
  instance = klass.newInstance()
  properties.each { k, v ->
    instance."${k}" = v
  }
  instance
}

println createInstance(Book, [title: 'Who moved my cheese', pages: 96]).dump()
println createInstance(CD, [title: 'Sound of nature', volume: 1]).dump()