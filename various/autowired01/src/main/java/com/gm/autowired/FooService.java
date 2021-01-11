package com.gm.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService { 
	
	// Autowiring property/field of a class directly
    @Autowired
    private FooFormatter fooFormatter;
    
    // This property/field is autowired with a setter method - setFooFormatter2()
    private FooFormatter fooFormatter2;
    
    // ALTERNATIVE 1
    // Do Autowired for both properties
    //
    // ALTERNATIVE 2
    // Create an Autowired constructor as below
    // @Autowired
    // public FooService(FooFormatter fooFormatter, FooFormatter fooFormatter) {
    //     this.fooFormatter = fooFormatter;
    //     this.fooFormatter2 = fooFormatter2;
    // }
    //
    // ALTERNATIVES - OTHER ALTERNATIVES - COULD BE MANY
    
    
    // METHODS
    
    @Autowired
    public void setFooFormatter2(FooFormatter aFooFormatter) {
     	this.fooFormatter2 = aFooFormatter;
    }
    
    public void doStuff() {
    	fooFormatter.format();
    	fooFormatter2.format();
    }
}