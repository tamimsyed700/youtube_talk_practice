module com.agiledeveloper.vendortwo {
  requires com.agiledeveloper.rates;
  
  provides com.agiledeveloper.rates.Vendor with com.agiledeveloper.vendor2.VendorTwo;
}