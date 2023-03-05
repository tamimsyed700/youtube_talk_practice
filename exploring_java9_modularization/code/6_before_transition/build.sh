/bin/rm -rf output
mkdir -p output
javac -d output -classpath /opt/junit/junit-4.12.jar com/sample/Sample.java
java -classpath output:/opt/junit/junit-4.12.jar:/opt/hamcrest/hamcrest-1.3/hamcrest-all-1.3.jar com.sample.Sample
