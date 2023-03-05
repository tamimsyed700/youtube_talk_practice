fun main() {
  val names = listOf("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques")
  println(names.filter { name -> name.length == 5 })
}
                        
//mkdir classes
//kotlinc-jvm -d classes
//java -classpath classes SampleKt
