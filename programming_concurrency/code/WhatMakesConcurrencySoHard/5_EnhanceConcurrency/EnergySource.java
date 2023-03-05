package com.agiledeveloper;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class EnergySource {
  private final long MAXLEVEL = 100;
  private AtomicLong level = new AtomicLong(MAXLEVEL);

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

  public long getUnitsAvailable() { return level.get(); }

  public boolean useEnergy(final long units) {
    long levelValue = level.get();
    if (units > 0 && levelValue >= units) {
      return level.compareAndSet(levelValue, levelValue - units);
    }
    return false;
  }

  private void replenish() {
      if (level.get() < MAXLEVEL) level.incrementAndGet();
  }
}
