====================
@Timed ANNOTATION
====================

REFERENCES:
In pure java, https://stackoverflow.com/questions/28499621/codahale-metrics-using-timed-metrics-annotation-in-plain-java
https://www.programcreek.com/java-api-examples/?api=com.codahale.metrics.annotation.Timed
With AspectJ: https://www.baeldung.com/timed-metrics-aspectj

For example and gradle: https://jar-download.com/artifacts/io.dropwizard.metrics/metrics-annotation/3.1.0/source-code/com/codahale/metrics/annotation/Timed.java

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