public class Sample {  
  public static void main(String[] args) {
    String text = "";
    int max = 100000;
    
    for(int i = 0; i < max; i++) {
      text += "" + i;
    }                
    
    System.out.println("done");
  }
}

/*              
mkdir classes
javac -d classes Sample.java
time java -classpath classes Sample
time java -classpath classes -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler Sample
cd classes
native-image Sample
time ./sample
*/