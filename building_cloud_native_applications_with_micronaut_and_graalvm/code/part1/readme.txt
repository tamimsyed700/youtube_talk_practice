mn --version

mn help

To create an application:
mn create-app com.agiledeveloper.stockinfo.stockinfo

To create a console client application:
mn create-cli-app com.agiledeveloper.stockclient.stockclient

To build for the JVM:
./gradlew assemble
java -jar ./build/libs/stockinfo-0.1-all.jar 

To build for GraalVM:
./gradlew nativeImage
./build/native-image/stockinfo

