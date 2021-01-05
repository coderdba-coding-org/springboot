package com.gm.timed;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;

@SpringBootApplication
public class Application {

	@Timed
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
		MetricRegistry metricRegistry = new MetricRegistry();
	    ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
	        .convertRatesTo(TimeUnit.SECONDS)
	        .convertDurationsTo(TimeUnit.MILLISECONDS)
	        .build();
	    reporter.start(5, TimeUnit.SECONDS);
	}
}
