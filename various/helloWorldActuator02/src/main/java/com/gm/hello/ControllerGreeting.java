package com.gm.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

// This is just a '@Controller' and not @RestController - because we will call @ResponseBody inside its method
@Controller
public class ControllerGreeting {
	
	  private static final String template = "Hello, %s!";
	  private final AtomicLong counter = new AtomicLong();

	  @GetMapping("/hello-world")
	  @ResponseBody
	  public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
	    return new Greeting(counter.incrementAndGet(), String.format(template, name));
	  }

}
