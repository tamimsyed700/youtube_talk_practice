import java.util.*;

class Vehicle {}
class Truck extends Vehicle {}
class Car extends Vehicle {
  private boolean electric;
  public Car(boolean electric) { this.electric = electric; }
  public boolean isElectric() { return electric; }
}

public class Sample {
  public static String process(Vehicle input) {
    return switch(input) {
      case Truck t -> "fill up";
      case Car c && c.isElectric() -> "charge";
      case Car c -> "fill up";
      default -> "Whatever";
    };
  }

  public static void main(String[] args) {
    System.out.println(process(new Truck()));
    System.out.println(process(new Car(false)));
    System.out.println(process(new Car(true)));
  }
}

