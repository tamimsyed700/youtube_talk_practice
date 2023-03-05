package com.agiledeveloper.vendor2;

import com.agiledeveloper.rates.Vendor;

public class VendorTwo implements Vendor {
  private VendorTwo(boolean preferred) {
    System.out.println("Vendor2 created");
  }
  
  public static VendorTwo provider() {
    return new VendorTwo(true);
  }
  
  public String getName() { return "Vendor2"; }
  public int getRate() { return 2; }
}
