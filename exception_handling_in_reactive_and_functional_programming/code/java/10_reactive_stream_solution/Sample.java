import java.util.*;
import java.util.function.*;
import java.io.*;
import java.net.*;
import io.reactivex.*;

public class Sample {
  public static String getNameOfAirport(String iata) throws IOException {
    var url = "https://soa.smext.faa.gov/asws/api/airport/status/" + iata;

    try(var scanner = new Scanner(new URL(url).openStream())) {
      var response = scanner.nextLine();

      if(!response.contains("Name")) {
	throw new RuntimeException("Invalid airport code " + iata);
      }

      return response.split("\"")[3];
      //way too lazy to do the real work to get the data
    }
  }

  public static void main(String[] args) {
    List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");
    
    Flowable.fromIterable(iataCodes)
      .map(Sample::getNameOfAirport)
      .map(String::toUpperCase)
      .subscribe(System.out::println, System.out::println);
  }
}

