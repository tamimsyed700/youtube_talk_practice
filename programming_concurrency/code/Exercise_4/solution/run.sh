javac -d . -classpath $AKKA_JARS *.java
java -classpath $AKKA_JARS:. com.agiledeveloper.StockInfo
