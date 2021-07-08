Reference: http://zetcode.com/springboot/component/#:~:text=%40Component%20is%20the%20most%20generic,used%20for%20more%20specific%20cases.

---------------
What is covered
---------------
@Component
run() --> by implementing CommandLineRunner interface
 
---------------
ADDITIONALLY
---------------
1. Added a rest controller - to see if the run() function of MyRunner implementing CommandLineRunner works or not
--> It did work - both rest controller as well as run() of MyRunner worked

2. Actuator
--> Enabled actuator by appropriate lines in build.gradle and application.properties
--> That worked too
--> localhost:8080/actuator, actuator/health, actuator/info, actuator/shutdown

3. Added calling a method run() within Application.java - using context
--> Based on http://zetcode.com/spring/configuration/

4. Added calling a static method staticRun() within Application.java - which does not need a context