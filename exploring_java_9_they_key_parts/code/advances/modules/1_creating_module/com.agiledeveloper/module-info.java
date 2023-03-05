module com.agiledeveloper { //to expose for reflection, open module com.agiledeveloper { or opens package like below
  exports com.agiledeveloper.util;
  
  //to export to a particular module, do
  //exports com.agiledeveloper.util to module.name.here
  
  //opens com.agiledeveloper.impl;
}