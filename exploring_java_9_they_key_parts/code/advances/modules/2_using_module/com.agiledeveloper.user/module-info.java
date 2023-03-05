module com.agiledeveloper.first {
  //requires com.agiledeveloper;
  
  requires transitive com.agiledeveloper; //option 2
  
  exports com.agiledeveloper.user;
}