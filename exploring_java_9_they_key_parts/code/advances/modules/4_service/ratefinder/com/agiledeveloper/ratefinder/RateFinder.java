package com.agiledeveloper.ratefinder;

import java.util.ServiceLoader;
import com.agiledeveloper.rates.Vendor;

public class RateFinder {
  public static void main(String[] args) {
    queryVendors();
  }                
  
  public static void queryVendors() {
    System.out.println("Let's use ServiceLoader to query all vendors");
    
    ServiceLoader<Vendor> vendors = ServiceLoader.load(Vendor.class);
    
    System.out.println("Iterarting over Vendors:");                
    
    for(Vendor vendor: vendors) {
      System.out.print("Vendor: ");
      System.out.print("Name: " + vendor.getName());
      System.out.println(" Price: " + vendor.getRate());
    }
    
    ServiceLoader<Vendor> vendors2 = ServiceLoader.load(Vendor.class);

    System.out.println("Iterarting over Providers:");
    
    vendors2.stream()
      .filter(provider -> provider.type().getName().contains("Two"))
      .peek(provider -> System.out.println("got a provider"))
      .map(provider -> provider.get())                         
      .forEach(vendor -> System.out.println(vendor.getName()));
  }
}