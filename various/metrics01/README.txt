================
REFERENCES
================

Main1: (git in brackets): 
	https://dzone.com/articles/restful-java-metering-by-dropwizard-metrics 
	(https://github.com/cloudskol/restskol)
	
Main1a: https://github.com/mwiede/metrics-feign/blob/master/src/test/java/com/github/mwiede/metrics/example/Example.java

To fix bean not found issue: https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component

For predestroy: https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component

For Timer: https://reflectoring.io/transparency-with-spring-boot/

For Timed: Needs additional setup:  Ryan Tenney stuff
	https://instil.co/blog/spring-boot-with-dropwizard-metrics/
	http://metrics.ryantenney.com/
	https://github.com/ryantenney/metrics-spring
	(from https://stackoverflow.com/questions/52322091/dropwizard-metrics-annotations-are-not-working-in-spring-boot-1-5)


================================
MAKING @Timed WORK
================================

https://stackoverflow.com/questions/56377196/timed-not-working-despite-registering-timedaspect-explicitly-spring-boot-2-1

For Timed: Needs additional setup: 
	https://instil.co/blog/spring-boot-with-dropwizard-metrics/
	http://metrics.ryantenney.com/
	(from https://stackoverflow.com/questions/52322091/dropwizard-metrics-annotations-are-not-working-in-spring-boot-1-5)
	
See the setup for build.gradle
And, additional stuff (search for Ryan) in Application.java
	
================
SETUP
================

-------------------
Lombok for Eclipse
-------------------
sudo java -jar lombok.jar

Then choose Eclipse
It will install
Then restart Eclipse

---------------
build.gradle
---------------
    // https://mvnrepository.com/artifact/io.dropwizard.metrics/metrics-core
    compile group: 'io.dropwizard.metrics', name: 'metrics-core', version: '4.1.16'
    
    // https://mvnrepository.com/artifact/io.dropwizard.metrics/metrics-annotation
    compile group: 'io.dropwizard.metrics', name: 'metrics-annotation', version: '4.1.16'
    
    // ADDED FOR LOMBOK GETTER, SETTER
    compileOnly 'org.projectlombok:lombok:1.18.16'
	annotationProcessor 'org.projectlombok:lombok:1.18.16'
	
	testCompileOnly 'org.projectlombok:lombok:1.18.16'
	testAnnotationProcessor 'org.projectlombok:lombok:1.18.16'
    
    // FOR @TIMED TO WORK WITH DROPWIZARD - AND SPRINGBOOT
	// https://instil.co/blog/spring-boot-with-dropwizard-metrics/
	compile ('com.ryantenney.metrics:metrics-spring:3.1.3') {
    	exclude group: 'com.codahale.metrics'
    	exclude group: 'org.springframework'
	}
---------------------
MetricRegistry Bean
---------------------
https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component

MetricRegistry Autowired does not work automatically - it expects a bean
- https://github.com/spring-projects/spring-boot/issues/11702
Therefore, coded that bean in Config.java
-- NOTE: If using Ryan Tenney stuff in the main Application java, then this bean is not required

	Maybe use Micrometer instead: 
	- https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0.0-M4-Release-Notes#user-facing-changes
	(redirected from https://github.com/spring-projects/spring-boot/issues/11702)

Without the bean, we get this error during runtime:
		***************************
		APPLICATION FAILED TO START
		***************************
		
		Description:
		
		Field metricRegistry in com.gm.metrics.AppMetricRegistry required a bean of type 'com.codahale.metrics.MetricRegistry' that could not be found.
		
		The injection point has the following annotations:
			- @org.springframework.beans.factory.annotation.Autowired(required=true)
		
		
		Action:
		
		Consider defining a bean of type 'com.codahale.metrics.MetricRegistry' in your configuration.
		
======================
LEARNINGS
======================

---------------------------------------
TIMED AND TIMER SHOW DIFFERENT VALUES
---------------------------------------

"Timer" and "@Timed" both were set for "/" endpoint.
Timer seems to show much lower time-taken millisecond values compared to @Timer
- Not sure if Timer is used correctly or if it is an inherent limitation between the two

-- Timers ----------------------------------------------------------------------
rest.call.timer
             count = 15
         mean rate = 0.06 calls/second
     1-minute rate = 0.08 calls/second
     5-minute rate = 0.04 calls/second
    15-minute rate = 0.02 calls/second
               min = 0.01 milliseconds
               max = 0.03 milliseconds
              mean = 0.01 milliseconds
            stddev = 0.01 milliseconds
            median = 0.01 milliseconds
              75% <= 0.01 milliseconds
              95% <= 0.03 milliseconds
              98% <= 0.03 milliseconds
              99% <= 0.03 milliseconds
            99.9% <= 0.03 milliseconds
timed.controllerHelloEndpointRoot.metrics
             count = 15
         mean rate = 0.06 calls/second
     1-minute rate = 0.09 calls/second
     5-minute rate = 0.04 calls/second
    15-minute rate = 0.02 calls/second
               min = 0.03 milliseconds
               max = 4.89 milliseconds
              mean = 0.33 milliseconds
            stddev = 1.15 milliseconds
            median = 0.04 milliseconds
              75% <= 0.04 milliseconds
              95% <= 4.89 milliseconds
              98% <= 4.89 milliseconds
              99% <= 4.89 milliseconds
            99.9% <= 4.89 milliseconds