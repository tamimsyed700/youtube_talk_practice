1. The service may fail at random moments due to the simulated failure.
2. Run two instances of the service

./gradlew assemble
java -jar ./build/libs/stockinfo-0.1-all.jar


3. The client fails when the service fails.

@Client(id = "stockinfo")
//@CircuitBreaker
public interface StockClient {


4. Mark the client interface with @circuitBreaker

@Client(id = "stockinfo")
@CircuitBreaker
public interface StockClient {

Now, when the service fails, the client automatically switches to another service.

