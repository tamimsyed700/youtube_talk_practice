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

    primes
      .filter(prime -> prime > 5)
      .map(prime -> prime + 1)
      .subscribe(
      prime -> System.out.println(prime),
      err -> System.out.println("Error: " + err),
      () -> System.out.println("DONE"));
  }

  private static void emit(Subscriber<? super Integer> emitter) {
    System.out.println("start emitting...");
    int index = 1;

    //isUnsubscribed is not needed in more recent versions...
    while(index < 1000 && !emitter.isUnsubscribed()) {
      if(isPrime(index)) {
        emitter.onNext(index);
        sleep(1000);
      }
      index++;
    }

    emitter.onCompleted();
  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}