package com.gm.postgres.models;

// Book entity from https://www.baeldung.com/spring-boot-hibernate

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // standard constructors
    public Book() {
    	
    }

    // standard getters and setters - TAKEN CARE OF BY LOMBOK
}
