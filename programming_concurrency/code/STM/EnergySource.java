package com.agiledeveloper;

import akka.AkkaException;
import akka.stm.Atomic;
import akka.stm.Ref;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static akka.stm.StmUtils.*;

public class EnergySource {
    private final long MAXLEVEL = 100;
    private Ref<Long> level = new Ref<Long>(MAXLEVEL);
    private Ref<Integer> usageCount = new Ref<Integer>(0);

    private static ScheduledExecutorService executorService
            = Executors.newScheduledThreadPool(10);

    private EnergySource() {
    }

    private void init() {
        executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                replenish();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void stopAllEnergySource() {
        executorService.shutdown();
    }

    public static EnergySource create() {
        EnergySource source = new EnergySource();
        source.init();
        return source;
    }

    public long getUnitsAvailable() {
        return level.get();
    }

    public boolean useEnergy(final long units) {
        return new Atomic<Boolean>() {
            @Override
            public Boolean atomically() {
                System.out.println("don't print messages like this");
                System.out.println("try to get units " + units);
                if(units > 0 && level.get() > units) {
                    level.swap(level.get() - units);
                    usageCount.swap(usageCount.get() + 1);
                    return true;
                }
                return false;
            }
        }.execute();
    }

    public int getUsage() {
        return usageCount.get();
    }

    private void replenish() {
        new Atomic<Object>() {
            @Override
            public Object atomically() {
                deferred(new Runnable() {
                    public void run() {
                        System.out.println("done with transaction, I can inform the world and make other changes");
                    }
                });

                compensating(new Runnable() {
                    public void run() {
                        System.out.println("hum, transaction failed, I need a shoulder to cry...");
                    }
                });


                if(level.get() < MAXLEVEL) {
                    level.swap(level.get() + 1);
                }
                return null;
            }
        }.execute();
    }
}
