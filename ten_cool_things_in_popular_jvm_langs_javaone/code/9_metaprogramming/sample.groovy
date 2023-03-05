class Person {
  def activities = []
  
  def work() { println 'working...' }
  def methodMissing(String name, args) {
    println "Intercepting call to $name"
    if(name.startsWith('play')) {
      def activity = name - 'play'
      if(activities.contains(activity)) {
        println "Caching call to $name"
        def impl = {Object[] theArgs -> println "I like to play $activity" }
        Person thisPerson = this
        thisPerson.metaClass."$name" = impl
        impl(args)
      }
      else
        println "Nope, can't play that $activity"
    } else {
      throw new MissingMethodException(this, name, args)
    }
  }
}

sam = new Person()
sam.work()
sam.activities = ['Tennis', 'Football']
sam.playTennis()
sam.playFootball()
sam.playTennis()
sam.playFootball()
sam.playTennis()
sam.playFootball()
sam.playPolitics()

/*
working...
Intercepting call to playTennis
Caching call to playTennis
I like to play Tennis
Intercepting call to playFootball
Caching call to playFootball
I like to play Football
I like to play Tennis
I like to play Football
I like to play Tennis
I like to play Football
Intercepting call to playPolitics
Nope, can't play that Politics
*/