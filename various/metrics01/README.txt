================
REFERENCES
================

Main1: Also, check this one (git in brackets): 
	https://dzone.com/articles/restful-java-metering-by-dropwizard-metrics 
	(https://github.com/cloudskol/restskol)
	
Main1a: https://github.com/mwiede/metrics-feign/blob/master/src/test/java/com/github/mwiede/metrics/example/Example.java

To fix bean not found issue: https://stackoverflow.com/questions/42230887/spring-boot-application-context-fails-to-load-external-component

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