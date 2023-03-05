package com.agiledeveloper;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class EnergySource {
  private final long MAXLEVEL = 100;
  private long level = MAXLEVEL;
  private int usageCount;

  private static ScheduledExecutorService timer =
          Executors.newScheduledThreadPool(10);

  private EnergySource() {}

  private void init() {
    timer.scheduleAtFixedRate(new Runnable() {
      public void run() { replenish(); }
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

  public synchronized long getUnitsAvailable() { return level; }
  public synchronized int getUsage() { return usageCount; }

  public synchronized boolean useEnergy(final long units) {
    long levelValue = level;
    if (units > 0 && levelValue >= units) {
      level -= units;
      usageCount++;
      return true;
    }
    return false;
  }

  private synchronized void replenish() {
      if (level < MAXLEVEL) level++;
  }
}
