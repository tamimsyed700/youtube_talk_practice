package com.agiledeveloper;

import akka.actor.ActorRef;
import akka.actor.ActorRegistry;
import akka.actor.Actors;

public class UseActor {
    public static void main(String[] args) throws InterruptedException {
        final ActorRef depp = Actors.actorOf(HollywoodActor.class).start();
        final ActorRef hanks = Actors.actorOf(HollywoodActor.class).start();
        //comment out one and then both threads and
        //see how the output (thread info) changes.
        System.out.println("Running main in " + Thread.currentThread());
        depp.sendOneWay("Sparrow");

        hanks.sendOneWay("Gump");

        Thread.sleep(100);
        depp.sendOneWay("Wonka");
        new Thread(new Runnable() {
            public void run() {
                depp.sendOneWay("Traveller");
            }
        }).start();

        //depp.stop();
        //hanks.stop();
        //or
        Actors.registry().shutdownAll();
    }
}
