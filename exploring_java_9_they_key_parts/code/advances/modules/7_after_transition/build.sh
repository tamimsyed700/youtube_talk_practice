/bin/rm -rf output
mkdir -p output/classes
cp /opt/hamcrest/hamcrest-1.3/hamcrest-all-1.3.jar output
cp /opt/junit/junit-4.12.jar output
javac --upgrade-module-path output -d output/classes com.sample/module-info.java com.sample/com/sample/Sample.java
jar -c -f output/sample.jar -C output/classes .
/bin/rm -rf output/classes
java -p output -m com.sample/com.sample.Sample
