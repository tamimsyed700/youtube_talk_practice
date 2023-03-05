1. Run two instances of the service

./gradlew assemble
java -jar ./build/libs/stockinfo-0.1-all.jar

2. Run the client, notice the service windows display which service was called.
The two service instances share the load.

