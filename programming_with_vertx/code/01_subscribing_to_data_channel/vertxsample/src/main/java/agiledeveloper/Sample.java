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
      prime -> System.out.println(prime));
  }

  private static void emit(Subscriber<? super Integer> emitter) {
    System.out.println("start emitting...");
    int index = 1;

    while(index < 1000) {
      if(isPrime(index)) {
        emitter.onNext(index);
        sleep(1000);
      }
      index++;
    }
  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}