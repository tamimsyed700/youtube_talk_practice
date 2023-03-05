module com.agiledeveloper.second {
  requires com.agiledeveloper.first; 
  
  //requires com.agiledeveloper; //option 1
  
  exports com.agiledeveloper.user.another;
}