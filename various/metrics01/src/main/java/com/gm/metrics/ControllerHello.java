package com.gm.metrics;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.Timer;

import com.gm.metrics.AppMetricRegistry;

// RestController combines Controller and ResponseBody
// ResponseBody tells Spring MVC not to render a model into a view but, rather, to write the returned object into the response body
@RestController
public class ControllerHello {
	
	@Autowired
	AppMetricRegistry appMetricRegistry;

	@RequestMapping("/")
	//Timed annotation is not working yet
	//@Timed (name = "controller.metrics")
	public String index() {
		
		Timer.Context callTimer = appMetricRegistry.getCallTimer().time();
		
		// 'finally' runs the code in that block - even though 'return' is done before that
		try {
			
		return "Greetings from Spring Boot!";
		
		} finally {
			appMetricRegistry.getCallCounter().inc();
			appMetricRegistry.getCallMeter().mark();
			callTimer.stop();
		}
	}

}
