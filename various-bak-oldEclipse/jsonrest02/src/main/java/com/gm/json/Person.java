package com.gm.json;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    
    // constructors
    public Person() {
    	
    }
    
    public Person(int id, String name) {
    	this.id = id;
    	this.name = name;
    }
}
