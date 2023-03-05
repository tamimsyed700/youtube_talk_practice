import java.util.*;
import java.util.concurrent.*;
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

  public static String fetchName(String iata) {
    return CompletableFuture.supplyAsync(() -> iata)
      .thenApply(convertToRuntimeException(Sample::getNameOfAirport))
      .thenApply(String::toUpperCase)
      .exceptionally(ex -> ex.getMessage())
      .join();
  }

  public static void main(String[] args) {
    List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");
    
    iataCodes.stream()
      .map(Sample::fetchName)
      .forEach(System.out::println);
  }
}

