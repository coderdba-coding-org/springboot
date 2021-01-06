package com.gm.metrics;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;

import com.gm.metrics.AppMetricRegistry;


// RestController combines Controller and ResponseBody
// ResponseBody tells Spring MVC not to render a model into a view but, rather, to write the returned object into the response body
@RestController
public class ControllerHello {
	
	@Autowired
	AppMetricRegistry appMetricRegistry;

	@RequestMapping("/")
	//@Timed (name = "controller.metrics")
	public String index() {
		
		appMetricRegistry.getCallCounter().inc();
		appMetricRegistry.getCallMeter().mark();
		
		return "Greetings from Spring Boot!";
	}

}
