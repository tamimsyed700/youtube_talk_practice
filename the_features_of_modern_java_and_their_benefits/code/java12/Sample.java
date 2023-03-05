import java.time.*;
import java.util.stream.*;

public class Sample {
  public static String activity(DayOfWeek dayOfWeek) {
    return switch(dayOfWeek) {
      case SATURDAY, SUNDAY -> "take it easy";
      case MONDAY, WEDNESDAY -> "Music lesson";
      case TUESDAY, THURSDAY -> {
        var sport = dayOfWeek == DayOfWeek.TUESDAY ? "Tennis" : "Soccer";
        
        yield "Play " + sport;
      }
      case FRIDAY -> "Theater";
    };
  }
  
  public static void main(String[] args) {
    Stream.of(DayOfWeek.values())
      .forEach(dayOfWeek -> System.out.println(dayOfWeek + ": " + activity(dayOfWeek)));
  }
}