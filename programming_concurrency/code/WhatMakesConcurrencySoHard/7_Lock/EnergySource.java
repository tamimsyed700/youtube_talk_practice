package com.agiledeveloper;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;

public class EnergySource {
    private final long MAXLEVEL = 100;
    private long level = MAXLEVEL;
    private int usageCount;
    private Lock lock = new ReentrantLock();

    private static ScheduledExecutorService timer =
            Executors.newScheduledThreadPool(10);

    private EnergySource() {
    }

    private void init() {
        timer.scheduleAtFixedRate(new Runnable() {
            public void run() {
                replenish();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void stopAllEnergySources() {
        timer.shutdown();
    }

    public static EnergySource create() {
        EnergySource energySource = new EnergySource();
        energySource.init();
        return energySource;
    }

    public long getUnitsAvailable() {
        try {
            lock.lock();
            return level;
        } finally {
            lock.unlock();
        }
    }

    public long getUsage() {
        try {
            lock.lock();
            return usageCount;
        } finally {
            lock.unlock();
        }
    }

    public boolean useEnergy(final long units) {
        try {
            lock.lock();
            long levelValue = level;
            if (units > 0 && levelValue >= units) {
                level -= units;
                usageCount++;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    private void replenish() {
        try {
            lock.lock();
            if (level < MAXLEVEL) level++;
        } finally {
            lock.unlock();
        }
    }
}
