=====================
REFERENCE
=====================
Based on https://spring.io/guides/gs/spring-boot/

===========
NOTES
===========
NOTE: @ResponseBody with @Controller 
- or - @RestController makes it serve a response-body and not a web UI output like html

==================
SETUP
==================
Updated these:
build.gradle - with springboot related stuff

gradle/gradle-wrapper.properties

Added actuator support in build.gradle
    // ADDED FOR SPRINGBOOT ACTUATOR SUPPORT
    implementation 'org.springframework.boot:spring-boot-starter-actuator'

Added application.properties support in build.gradle:
processResources {
    expand(project.properties)
}

Created application.properties (see 'shutdown' endpoint section below)
- To enable shutdown, create application.properties in the project root folder (or src/main/java:
Note: Sometimes, application.properties in src/main/java only is read (see configuration01 example)

management.endpoint.shutdown.enabled=true
management.endpoints.web.exposure.include=health,info,shutdown

==================
ACTUATOR ENDPOINTS
==================
actuator/health
actuator/info
actuator

==============================
Additional endpoint 'shutdown'
==============================
actuator/shutdown

To enable shutdown, create application.properties in the project root folder (as desribed above)

==================
TO RUN
==================
$ gradlew bootRun

$ curl localhost:8080
Greetings from Spring Boot!

==================
ACCESS ACTUATORS
==================
$ curl localhost:8080/actuator/health
$ curl localhost:8080/actuator/info
$ curl localhost:8080/actuator/

Shutdown endpoint:
$ curl -X POST localhost:8080/actuator/shutdown

==================
TO TEST
==================
$ gradle test --tests com.gm.hello.TestControllerHello
$ gradle test --tests com.gm.hello.TestControllerHello --info
$ gradle test --tests com.gm.hello.TestControllerHello --debug

For any test failures - report will be in files like:
./build/reports/tests/test/index.html

==================
TO PACKAGE AS JAR
==================
$ gradle build
Then look in build/libs folder