1. Run consul

docker run -p 8500:8500 consul

2. In the stockinfo directory

mn
mn> feature-diff --features discovery-consul

3. add to build.gradle

    implementation("io.micronaut.discovery:micronaut-discovery-client")

4. Edit application.yml

micronaut:
  application:
    name: stockinfo
  server:
    port: -1

consul:
  client:
    registration:
      enabled: true
    defaultZone: ${CONSUL_HOST:localhost}:${CONSUL_PORT:8500}

5. In the stockclient project, add to build.gradle

    implementation("io.micronaut.discovery:micronaut-discovery-client")

6. Edit application.yml

micronaut:
  application:
    name: stockclient

consul:
  client:
    registration:
      enabled: true
    defaultZone: "${CONSUL_HOST:localhost}:${CONSUL_PORT:8500}"

7. Edit StockClient

@Client(id = "stockinfo")
public interface StockClient {
...

8. 
Run the server and the client.

