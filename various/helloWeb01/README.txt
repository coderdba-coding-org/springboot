Based on https://spring.io/guides/gs/serving-web-content/

To setup and run - use instructions in README.txt of helloWorldActuator01
Add Thymeleaf to build.gradle in addition to other springboot stuff

To access the URL: 
http://localhost:8080/greeting?nameParam=Boy --> will display Hello Boy!
http://localhost:8080/greeting --> will display Hello World!

NOTES:
In the 'controller' program we dont use @ResponseBody here, 
or, @RestController  in the place of @Controller
- so that, we serve a model as UI output and not as response-body 