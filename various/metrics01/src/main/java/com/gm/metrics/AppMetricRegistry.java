package com.gm.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

//import lombok.Getter;
//import lombok.Setter;

@Component
public class AppMetricRegistry {
	
    @Autowired
    MetricRegistry metricRegistry;
    
    private Meter   callMeter;
    private Counter callCounter;

    @PostConstruct
    public void setUpMetrics() {
    	
    	callMeter = metricRegistry.meter("rest.call.meter");
        callCounter = metricRegistry.counter("rest.call.counter");
        
        startReport();
        
    }
    
    void startReport() {
		//MetricRegistry metricRegistry = new MetricRegistry();
		
	    ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
	        .convertRatesTo(TimeUnit.SECONDS)
	        .convertDurationsTo(TimeUnit.MILLISECONDS)
	        .build();
	    
	    System.out.println ("Metric Registry Contents: " + metricRegistry.getTimers().toString());

	    reporter.start(5, TimeUnit.SECONDS); 
	    
	}
    
    @Configuration
    public class ServiceConfig {

        @Bean
        public MetricRegistry getMetricsRegistry(){
            return new MetricRegistry();
        }

    }

}
