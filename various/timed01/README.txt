====================
@Timed ANNOTATION
====================

https://dzone.com/articles/dropwizard-part-3-measuring-your-application-metri

REFERENCES:
Java: https://stackoverflow.com/questions/28499621/codahale-metrics-using-timed-metrics-annotation-in-plain-java
- also shows what all metrics are collected

Springboot: https://docs.spring.io/spring-metrics/docs/current/public/atlas
ConsoleReporter, CSV Reporter etc: https://metrics.dropwizard.io/4.1.2/getting-started.html#console-reporter 

ConsoleReporter: https://micrometer.io/docs/guide/consoleReporter

==================
https://www.programcreek.com/java-api-examples/?api=com.codahale.metrics.annotation.Timed
With AspectJ: https://www.baeldung.com/timed-metrics-aspectj
Some article: https://stackoverflow.com/questions/47932122/dropwizard-metric-annotations-timed-not-working

For example and gradle: https://jar-download.com/artifacts/io.dropwizard.metrics/metrics-annotation/3.1.0/source-code/com/codahale/metrics/annotation/Timed.java

Codahale Timed example: https://dropwizardio.readthedocs.io/en/v0.7.0/getting-started.html

Codahale meter - and "Reporting via JMX", Reporting Via HTTP, : https://metrics.dropwizard.io/3.1.0/getting-started/
	Also:
	Other Reporting
	In addition to JMX and HTTP, Metrics also has reporters for the following outputs:
	
	STDOUT, using ConsoleReporter from metrics-core
	CSV files, using CsvReporter from metrics-core
	SLF4J loggers, using Slf4jReporter from metrics-core
	Ganglia, using GangliaReporter from metrics-ganglia
	Graphite, using GraphiteReporter from metrics-graphite

	Also see exmaple of STDOUT ConsoleReporter:
	    Best: https://metrics.dropwizard.io/4.1.2/getting-started.html#console-reporter 
		https://metrics.dropwizard.io/3.1.0/manual/core/#man-core-reporters-console
		https://www.baeldung.com/dropwizard-metrics
		https://www.programcreek.com/java-api-examples/?class=com.codahale.metrics.ConsoleReporter&method=report
		https://www.codota.com/code/java/classes/com.codahale.metrics.ConsoleReporter
		https://www.programcreek.com/java-api-examples/?api=com.codahale.metrics.ConsoleReporter
	
	
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