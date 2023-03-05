package com.agiledeveloper;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;

public class Sample {
  public static void main(String[] args) {
    final ActorSystem actorSystem = ActorSystem.create();

    final Collector collector = TypedActor.get(actorSystem).typedActorOf(new TypedProps<CollectorImpl>(
        Collector.class, CollectorImpl.class));

    collector.buy(100);
    collector.sell(50);

    System.out.println(collector.getItemsCount());
  }
}
