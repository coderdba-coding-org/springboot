package com.gm.json;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;

@RestController	
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService personService;

	//@PostMapping(value = "/createPerson", consumes = "application/json", produces = "application/json")
	@PostMapping("/createPerson")
	public Person createPerson(@RequestBody Person person) {
		return personService.saveUpdatePerson(person);
	}

	// We are using HttpServeletResponse instead of @ResponseBody - as in Baeldung reference
	// HttpServeletResponse is used to set headers in the response
	// @ResponseBody is implicit in @RestController above in class definition
	@PostMapping(value = "/updatePerson", consumes = "application/json", produces = "application/json")
	public Person updatePerson(@RequestBody Person person, HttpServletResponse response) {
		
		response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
			    .path("/findPerson/" + person.getId()).toUriString());
			    
	    return personService.saveUpdatePerson(person);
	}
	
}
