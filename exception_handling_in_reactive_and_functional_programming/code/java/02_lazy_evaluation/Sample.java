import io.reactivex.*;
import io.reactivex.schedulers.*;

public class Sample {
  public static Flowable<Integer> create() {
    return Flowable.<Integer>create(emitter -> emit(emitter), BackpressureStrategy.DROP);
  }

  public static void emit(FlowableEmitter<Integer> emitter) {
    System.out.println("Starting emit...");
    int count = 0;

    while(count < 10 && !emitter.isCancelled()) {
      System.out.println("emitting..." + count);

      emitter.onNext(count++);

      try { Thread.sleep(500); } catch(Exception ex) {}
    }

    emitter.onComplete();
  }

  public static void process(String msg, int data) {
    try { Thread.sleep(1000); } catch(Exception ex) {}

    System.out.println(msg + ": " + data);
  }

  public static void main(String[] args) throws Exception{
    var feed = create()
      .observeOn(Schedulers.io(), true, 2);

    feed.subscribe(data -> process("S1", data)); 

    Thread.sleep(10000);
  }
}

