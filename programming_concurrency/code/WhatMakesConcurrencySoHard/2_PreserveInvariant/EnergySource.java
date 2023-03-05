package com.agiledeveloper;
public class EnergySource {
  private final long MAXLEVEL = 100;
  private long level = MAXLEVEL;
  private boolean keepRunning = true;

  private EnergySource() {}

  private void init() {
    new Thread(new Runnable() {
      public void run() { replenish(); }
    }).start();
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

  public void stopEnergySource() { keepRunning = false; }

  private void replenish() {
    while(keepRunning) {
      if (level < MAXLEVEL) level++;

      try { Thread.sleep(1000); } catch(InterruptedException ex) {}
    }
  }
}
