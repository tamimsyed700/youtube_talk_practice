import org.graalvm.polyglot.*;

public class Sample {  
  public static void main(String[] args) {
    String script = "console.log(`hi ${name}`); const response = 'Thank you';";
    
    Context context = Context.create("js");
    Value bindings = context.getBindings("js");
    bindings.putMember("name", "Jane");
    
    context.eval("js", script);
    
    System.out.println(bindings.getMember("response").toString());
  }
}

/*
javac -d classes Sample.java
java -classpath classes Sample
*/