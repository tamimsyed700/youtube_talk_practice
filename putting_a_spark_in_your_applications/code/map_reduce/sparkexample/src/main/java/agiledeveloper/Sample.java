package agiledeveloper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Sample {
  public static void main(String[] args) throws IOException {

    final Stream<String> lines = Files.lines(Paths.get("../inputfile.txt"));

    Timeit.code(() ->
      System.out.println(
        lines
          .flatMap(line -> Stream.of(line.split(" ")))
          .filter(word -> word.equals("the"))
          .mapToLong(the -> 1)
          .reduce(0, Long::sum)));
  }
}