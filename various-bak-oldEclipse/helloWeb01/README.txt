===============
REFERENCE
===============
Based on https://spring.io/guides/gs/serving-web-content/

===============
SETUP
===============

1. To setup and run - use instructions in README.txt of helloWorldActuator01
Add Thymeleaf to build.gradle in addition to other springboot stuff

2. Create greeting-html.html in src/main/resources folder
--> This template is used to serve 'web' UI content

===============
ACCESS URLs
===============
To access the URL: 
http://localhost:8080/greeting?nameParam=Boy --> will display Hello Boy!
http://localhost:8080/greeting --> will display Hello World!

===============
NOTES
===============
In the 'controller' program we dont use @ResponseBody here, 
or, @RestController  in the place of @Controller
- so that, we serve a model as UI output and not as response-body 

===============================================
OUTPUT - IF CODED AS REST - as in HelloWorldClassic01
===============================================
$ curl http://localhost:8080/
Greetings from Spring Boot

===============================================
OUTPUT - OF THIS ONE, CODED AS WEB
===============================================
$ curl http://localhost:8080/greeting
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p >Hello, World!</p>
</body>