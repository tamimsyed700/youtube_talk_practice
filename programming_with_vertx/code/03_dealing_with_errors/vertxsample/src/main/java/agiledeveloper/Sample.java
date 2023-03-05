package agiledeveloper;

import rx.Observable;
import rx.Subscriber;

import java.util.stream.IntStream;

public class Sample {
  public static boolean isPrime(int number) {
    return number > 1 &&
        IntStream.range(2, number)
                 .noneMatch(i -> number % i == 0);
  }

  public static void main(String[] args) {
    final Observable<Integer> primes = Observable.<Integer>create(emitter -> emit(emitter));

    System.out.println("created observable");

    primes.subscribe(
      prime -> System.out.println(prime),
      err -> System.out.println("Error: " + err),
      () -> System.out.println("DONE"));
  }

  private static void emit(Subscriber<? super Integer> emitter) {
    System.out.println("start emitting...");
    int index = 1;

    while(index < 15) {
      if(isPrime(index)) {
        emitter.onNext(index);
        sleep(1000);
      }
      if(index > 9) {
        //throw new RuntimeException("oops, something went wrong");
        //the above is useful to show that unhandled exceptions propagate as error
        //through the error channel.

        //Instead, we can be more civil and send error through
        //the error channel ourselves

        emitter.onError(new RuntimeException("oops something went wrong"));
      }
      index++;
    }

    emitter.onCompleted();
    emitter.onNext(-1);
  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}