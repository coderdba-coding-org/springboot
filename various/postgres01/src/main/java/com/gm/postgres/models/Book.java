package com.gm.postgres.models;

// Book entity from https://www.baeldung.com/spring-boot-hibernate

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="BOOK") // from https://zetcode.com/springboot/postgresql/
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // strategy taken from https://zetcode.com/springboot/postgresql/
    private Long id;
    private String name;

    // standard constructors
    public Book() {
    	
    }
    
    public Book(Long id, String name) {
    	this.id = id;
    	this.name = name;
    }

    // standard getters and setters - TAKEN CARE OF BY LOMBOK
    
    // from https://zetcode.com/springboot/postgresql/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
