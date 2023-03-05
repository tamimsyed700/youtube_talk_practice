1. Edit the build.gradle for the service

    annotationProcessor("io.micronaut.openapi:micronaut-openapi")
    implementation("io.swagger.core.v3:swagger-annotations")

2. Edit the Application class

@OpenAPIDefinition(info = @Info(title = "stockinfo", version = "0.0"))
@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
...

3. Edit application.yml

micronaut:
  application:
    name: stockinfo
  server:
    port: -1
  router:
    static-resources:
      swagger:
        paths: classpath:META-INF/swagger
        mapping: /swagger/**
      swagger-ui:
        paths: classpath:META-INF/swagger/views/swagger-ui
        mapping: /swagger-ui/**

consul:
  client:
    registration:
      enabled: true
    defaultZone: ${CONSUL_HOST:localhost}:${CONSUL_PORT:8500}

r2dbc:
  datasources:
    default:
      schema-generate: CREATE_DROP
      dialect: H2
      url: r2dbc:h2:mem:///stocksdb;DB_CLOSE_ON_EXIT=FALSE
      username: sa
      password: ''
      options:
        DB_CLOSE_DELAY: -1
        protocol: mem


4. Edit build.gradle to add

tasks.withType(JavaCompile) {
  options.fork = true
  options.forkOptions.jvmArgs << '-Dmicronaut.openapi.views.spec=rapidoc.enabled=true,swagger-ui.enabled=true,swagger-ui.theme=flattop'
}

5. Change the controller's route:

@Controller("/stocks")
public class StockController {
  private StockService stockService;
...

6. Run the service.

7. Take a look at 

build/classes/java/main/META-INF/swagger/stockinfo-0.0.yml

8. Visit http://localhost:PORT/swagger-ui
where PORT is the port number on which the service is running.

9. Play with the swagger-ui, using the "Try it out" feature.

