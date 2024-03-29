package com.gm.timed;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;

// RestController combines Controller and ResponseBody
// ResponseBody tells Spring MVC not to render a model into a view but, rather, to write the returned object into the response body
@RestController
public class ControllerHello {

	@RequestMapping("/")
	@Timed (name = "controller.metrics")
	public String index() {
		
		return "Greetings from Spring Boot!";
	}

}
