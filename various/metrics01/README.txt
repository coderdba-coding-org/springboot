================
REFERENCES
================

Main1: Also, check this one (git in brackets): 
	https://dzone.com/articles/restful-java-metering-by-dropwizard-metrics 
	(https://github.com/cloudskol/restskol)
	
Main1a: https://github.com/mwiede/metrics-feign/blob/master/src/test/java/com/github/mwiede/metrics/example/Example.java

To fix bean not found issue: https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component

For predestroy: https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component


================================
TBD - @Timed is not yet working
================================

https://stackoverflow.com/questions/56377196/timed-not-working-despite-registering-timedaspect-explicitly-spring-boot-2-1

================
SETUP
================

---------------
build.gradle
---------------
    // https://mvnrepository.com/artifact/io.dropwizard.metrics/metrics-core
    compile group: 'io.dropwizard.metrics', name: 'metrics-core', version: '4.1.16'
    
    // https://mvnrepository.com/artifact/io.dropwizard.metrics/metrics-annotation
    compile group: 'io.dropwizard.metrics', name: 'metrics-annotation', version: '4.1.16'
    
---------------------
MetricRegistry Bean
---------------------
https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component

MetricRegistry Autowired does not work automatically - it expects a bean
- https://github.com/spring-projects/spring-boot/issues/11702
Therefore, coded that bean in Config.java

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