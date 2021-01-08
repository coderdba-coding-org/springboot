package com.gm.json;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController	
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService personService;

	@PostMapping(value = "/createPerson", consumes = "application/json", produces = "application/json")
	public Person createPerson(@RequestBody Person person) {
		return personService.saveUpdatePerson(person);
	}

	// We are using HttpServeletResponse instead of @ResponseBody - as in Baeldung reference
	@PostMapping(value = "/updatePerson", consumes = "application/json", produces = "application/json")
	public Person updatePerson(@RequestBody Person person, HttpServletResponse response) {
		response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
			    .path("/findPerson/" + person.getId()).toUriString());
			    
	    return personService.saveUpdatePerson(person);
	}
	
}
