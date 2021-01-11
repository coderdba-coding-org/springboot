package com.gm.autowired;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter {
	
	// constructor
	// NO CONSTRUCTOR INTENDED
	// Creating a simple constructor to print if this class is instantiated
	public FooFormatter() {
		System.out.println ("In FooFormatter class");
	}
	
	// method
    public String format() {
    	
    	System.out.println ("In FooFormatter class: format() method");
        return "foo";
    }
}