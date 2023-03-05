package com.agiledeveloper;

import java.util.concurrent.*;

public class EnergySource {
  private final long MAXLEVEL = 100;
  private long level = MAXLEVEL;

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

  public long getUnitsAvailable() { return level; }

  public boolean useEnergy(final long units) {
    if (units > 0 && level >= units) {
      level -= units;
      return true;
    }
    return false;
  }

  private void replenish() {
      if (level < MAXLEVEL) level++;
  }
}
