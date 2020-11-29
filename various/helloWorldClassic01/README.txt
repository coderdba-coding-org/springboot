Based on https://spring.io/guides/gs/spring-boot/

==================
SETUP
==================
Updated these:
build.gradle
gradle/gradle-wrapper.properties

==================
TO RUN
==================
$ gradlew bootRun

$ curl localhost:8080
Greetings from Spring Boot!

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