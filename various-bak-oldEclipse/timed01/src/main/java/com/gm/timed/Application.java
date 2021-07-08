package com.gm.timed;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.Meter;

@SpringBootApplication
public class Application {
	
	public static MetricRegistry metricRegistry = new MetricRegistry();
	public Meter reqeusts = metricRegistry.meter("requestCount");

	@Timed (name = "main.metrics")
	public static void main(String[] args) {
		
		// Start reportint timed metrics
		startReport();
		
		// This is the runner of the application
		// Functionalities are loaded based on annotations in programs
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// This part of beans is just to print info - not core need
		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	
	static void startReport() {
		//MetricRegistry metricRegistry = new MetricRegistry();
		
	    ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
	        .convertRatesTo(TimeUnit.SECONDS)
	        .convertDurationsTo(TimeUnit.MILLISECONDS)
	        .build();
	    
	    System.out.println ("Metric Registry Contents: " + metricRegistry.getTimers().toString());

	    reporter.start(5, TimeUnit.SECONDS); 
	    
	}
	
	@RestController
	public class MainControllerHello {

		@RequestMapping("/hello")
		@Timed (name = "maincontroller.metrics")
		public String index() {
			
			reqeusts.mark();
			
		    System.out.println ("Metric Registry Contents in MainControllerHello : " + metricRegistry.getTimers().toString());

			return "Greetings from Spring Boot - maincontroller!";
		}

	}
}
