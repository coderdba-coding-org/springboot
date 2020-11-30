package com.gm.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

	// nameParam is the http query parameter like: http://localhost:8080/greeting?nameParam=Boy
	// name is the parameter variable assigned in @RequestParam
	// nameValue is the variable in the html file greeting-html.html in src/main/resources folder
	
	// Note that we dont use @ResponseBody here, or, @RestController above in the place of @Controller
	// - so that, we serve a model as UI output and not as response-body 
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="nameParam", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("nameValue", name);
		return "greeting-html";
	}

}