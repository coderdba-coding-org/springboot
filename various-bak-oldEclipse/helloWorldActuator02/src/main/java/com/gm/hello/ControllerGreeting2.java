package com.gm.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

// Alternatively instead of @Controller, @GetMapping, @ResponseBody - use @RestController and @RequestMapping
//@Controller
@RestController
public class ControllerGreeting2 {
	
	  private static final String template = "Hello, %s!";
	  private final AtomicLong counter = new AtomicLong();

	  @RequestMapping("/hello-world2")
	  //@GetMapping("/hello-world2")
	  //@ResponseBody
	  public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
	    return new Greeting(counter.incrementAndGet(), String.format(template, name));
	  }

}
