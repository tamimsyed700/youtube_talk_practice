package com.agiledeveloper;

import java.util.concurrent.*;

public class UseEnergySource {
  public static void main(String[] args) throws Exception {
    final EnergySource energySource = EnergySource.create();

    ExecutorService executorService = Executors.newFixedThreadPool(50);

    for(int i = 0; i < 50; i++) {
      executorService.execute(new Runnable() {
        public void run() { energySource.useEnergy(1); }
      });
    }
    executorService.shutdown();

    Thread.sleep(1000);
    System.out.println("Available: " + energySource.getUnitsAvailable());
    System.out.println("Usage: " + energySource.getUsage());
    EnergySource.stopAllEnergySources();
  }
}
