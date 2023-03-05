ExpandoMetaClass.enableGlobally()

class Person {
  def work() { println  "working..." }
  
  def methodMissing(String name, args) {
    println "Intercepting call"
    if (name.startsWith('play')) {
      def impl = { Object[] arguments ->
        println "Playing ${name.split('play')[1]}"
      }
      
      Person.metaClass."$name" = impl
      impl(args)
    }
  }
}

peter = new Person()
peter.work()
peter.playTennis()
peter.playTennis()
peter.playFootball()
peter.playTennis()
