package com.gm.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public String index() {
		
		// Note: We are returning a Greeting object here, along with a String 
		return ("Try /greeting endpoint");
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		// Note: We are returning a Greeting object here - constructed calling 'new'
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
