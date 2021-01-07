==================
REFERENCE
==================
Based on https://spring.io/guides/gs/spring-boot/
--> This is a bit different from https://spring.io/guides/gs/rest-service/
    In the sense that 
    the former serves just a string output, 
    the latter serves a JSON - which is a dump of a Greeting object
    	See hellowWorldJson01 for the latter

==================
NOTES
==================
NOTE: @ResponseBody with @Controller 
- or - @RestController makes it serve a response-body and not a web UI output like html

--> This is different from how it is implemented as a web-UI response and not response-body 
    as in helloWeb01 based on Based on https://spring.io/guides/gs/serving-web-content/

==================
SETUP
==================
Updated these:
build.gradle
gradle/wrapper/gradle-wrapper.properties

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

==============================
TESTING - UNIT, INTEGRATION
==============================
From: https://spring.io/guides/gs/spring-boot/

MockMvc comes from Spring Test and lets you, through a set of convenient builder classes, 
send HTTP requests into the DispatcherServlet and make assertions about the result. 
Note the use of @AutoConfigureMockMvc and @SpringBootTest to inject a MockMvc instance. 
Having used @SpringBootTest, we are asking for the whole application context to be created. 

An alternative would be to ask Spring Boot to create only the web layers of the context 
by using @WebMvcTest. In either case, Spring Boot automatically tries to locate 
the main application class of your application, but you can override it or narrow it down 
if you want to build something different.

As well as mocking the HTTP request cycle, you can also use Spring Boot to write a simple 
full-stack integration test. For example, instead of (or as well as) the mock test shown earlier, 
we could create the following test (from src/test/java/com/example/springboot/HelloControllerIT.java):
