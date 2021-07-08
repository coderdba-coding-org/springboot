package com.gm.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ConsoleReporter;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AppMetricRegistry {
	
	// This autowiring needs a bean to get MetricRegistry object - coded in Config.java
    @Autowired
    MetricRegistry metricRegistry;
    
    private Meter   callMeter;
    private Counter callCounter;
    private Timer   callTimer;
    private ConsoleReporter reporter;
    private Histogram callHistogram;

    @PostConstruct
    public void setUpMetrics() {
    	
    	callMeter = metricRegistry.meter("rest.call.meter");
        callCounter = metricRegistry.counter("rest.call.counter");
        callTimer = metricRegistry.timer("rest.call.timer");
        callHistogram = metricRegistry.histogram("rest.call.histogram");
        
        startReport();
        
    }
    
    @PreDestroy
    public void destropMetricsContext() {

        if (reporter != null)
            reporter.stop();
    }
    
    void startReport() {
		//MetricRegistry metricRegistry = new MetricRegistry();
		
	    //ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
    	
    	reporter = ConsoleReporter.forRegistry(metricRegistry)
	        .convertRatesTo(TimeUnit.SECONDS)
	        .convertDurationsTo(TimeUnit.MILLISECONDS)
	        .build();
	    
	    System.out.println ("Metric Registry Contents: " + metricRegistry.getTimers().toString());

	    reporter.start(5, TimeUnit.SECONDS); 
	    
	}
    
    // Defined configuration in Config.java
    /*
    @Configuration
    public class ServiceConfig {

        @Bean
        public MetricRegistry getMetricsRegistry(){
            return new MetricRegistry();
        }

    }
    */

}
