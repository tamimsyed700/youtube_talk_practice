public class Sample {
  public static void main(String[] args) {
    SeaPlane seaPlane = new SeaPlane();
    seaPlane.takeOff();
    seaPlane.turn();
    seaPlane.cruise();
    seaPlane.land();
  }
}


/*
4 rules of default method.
1. You get the default methods of what you extend or implement
2. You can override default methods
3. Methods in the class hierarchy take precedence over any default method
4. If methods collide, you have to disambiguate.
*/