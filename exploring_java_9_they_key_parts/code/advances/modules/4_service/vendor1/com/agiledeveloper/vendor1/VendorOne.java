package com.agiledeveloper.vendor1;

import com.agiledeveloper.rates.Vendor;

public class VendorOne implements Vendor {
  public VendorOne() {
    System.out.println("Vendor1 created");    
  }
  
  public String getName() { return "Vendor1"; }
  public int getRate() { return 1; }
}
