package com.gm.json;

import org.springframework.stereotype.Service;

@Service
public class PersonService implements PersonServiceInterface {
	
    public Person saveUpdatePerson(Person person) {
    	
    	System.out.println("In PersonService:saveUpdatePerson");
    	return person;
    	
    }
    
    public Person findPersonById(Integer id) {
    	
    	System.out.println("In PersonService:findPersonById");
    	return new Person(id, "person of " + id);
    	
    }

}