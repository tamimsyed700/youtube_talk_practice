import java.util.*;
import java.util.function.*;
import java.io.*;
import java.net.*;

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

  interface FunctionEx<T, R> {
    R apply(T input) throws Exception;
  }

  public static <T, R> Function<T, R> convertToRuntimeException(FunctionEx<T, R> func) {
    return input -> {
      try {
        return func.apply(input);
      } catch(Exception ex) {
        throw new RuntimeException(ex);
      }
    };
  }

  public static void main(String[] args) {
    List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

    iataCodes.parallelStream()
      .map(convertToRuntimeException(Sample::getNameOfAirport))
      //Hum.... really?
      .map(String::toUpperCase)
      .forEach(System.out::println);


    //This code is not behaving like the imperative style equivalent.
    //The stack blows up, the report was not graceful, 
    //and SAT was not processed.
  }
}

//This pattern I like to call it as curl up in a corner and cry
