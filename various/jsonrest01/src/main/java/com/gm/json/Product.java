package com.gm.json;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Product {

    private int id;
    private String name;
    private double price;

    // constructors
    public Product() {
    	
    }
    
    public Product(int id, String name, double price) {
    	this.id = id;
    	this.name = name;
    	this.price = price;
    }
}
