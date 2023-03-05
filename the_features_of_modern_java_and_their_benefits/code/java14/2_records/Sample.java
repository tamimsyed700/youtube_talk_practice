import java.util.*;

record Location(double lat, double lon) {
  public Location {
    if(Math.abs(lat) > 180 || Math.abs(lon) > 180) {
      throw new RuntimeException("Invalid values for lat or lon");
    }
  }
}

public class Sample {  
  public static void main(String[] args) {
    var location1 = new Location(121.35, -84.23);
    var location2 = new Location(121.35, -84.23);
    var location3 = new Location(141.35, -84.23);
    
    System.out.println(location1);
    System.out.println(location1.lat());
    System.out.println(location1.lon());
    
    System.out.println(location1.equals(location2));
    System.out.println(location1.equals(location3));
    
    try {
      new Location(190.1, 200);
    } catch(Exception ex) {
      System.out.println(ex);
    }
  }
}