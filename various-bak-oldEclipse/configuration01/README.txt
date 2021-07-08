Reference: http://zetcode.com/spring/configuration/


This does NOT have a rest-controller
Therefore, it just runs and exits
Even though we haver actuator support added in build.gradle, without a rest controller, those wont activate

=================
SETUP
=================

---------------------------
application.properties
---------------------------
application.properties file had to be placed under src/main/java 
- because placing it in root folder did not work - it gave file not found
- however, placing it in root folder worked in helloWorldActuator01 and 02 projects

---------------------------
Other setup
---------------------------
build.gradle
gradle/wrapper/gradle-wrapper.properties