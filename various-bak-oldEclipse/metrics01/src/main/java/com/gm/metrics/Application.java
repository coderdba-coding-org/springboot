package com.gm.metrics;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.Meter;

import com.gm.metrics.AppMetricRegistry;

// Ryan Tenney stuff for enabling Timed metrics 
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

@SpringBootApplication
//Make your SpringBootApplication extend Ryan Tenney’s MetricsConfigurerAdapter 
// and add his @EnableMetrics(proxyTargetClass = true) annotation to your Application class.
@EnableMetrics(proxyTargetClass = true) 
public class Application extends MetricsConfigurerAdapter {
	
	//public static MetricRegistry metricRegistry = new MetricRegistry();
	//public Meter reqeusts = metricRegistry.meter("requestCount");
	
	@Autowired
	AppMetricRegistry appMetricRegistry;	


	//Timed annotation does not work for main method
	//@Timed (name = "timed.mainApplicationMainMethod.metrics")
	public static void main(String[] args) {
		
		// This is the runner of the application
		// Functionalities are loaded based on annotations in programs
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		/*
		// This part of beans is just to print info - not core need
		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		*/
	}
}
