package com.gm.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooService { 
	
	// Autowiring property/field of a class directly
    @Autowired
    private FooFormatter fooFormatter;
    
    // This property/field is autowired with a setter method - setFooFormatter2()
    private FooFormatter fooFormatter2;
    
    // ALTERNATIVE 1
    // Do Autowired for both properties fooFrmatter and fooFormatter2
    //
    // ALTERNATIVE 2
    // Create an Autowired constructor as below
    // @Autowired
    // public FooService(FooFormatter fooFormatter, FooFormatter fooFormatter) {
    //     this.fooFormatter = fooFormatter;
    //     this.fooFormatter2 = fooFormatter2;
    // }
    //
    // ALTERNATIVE 3
    // Use an autowired setter method (see below)
    //
    // ALTERNATIVES - OTHER ALTERNATIVES - COULD BE MANY
    
    @Autowired
    public void setFooFormatter2(FooFormatter aFooFormatter) {
     	this.fooFormatter2 = aFooFormatter;
    }
 
    /* Somehow this is not understood/working
    @Autowired(required = false)
    private FooDAOx dataAccessor; 
    */
    
    // Disambiguation with @Qualifier when multiple classes implement an interface like Formatter
    @Autowired
    @Qualifier("oneFormatter")
    private Formatter myFormatter;
    
    // Autowiring by name - if the property/field of a class matches with the bean-name then the property will be assigned that bean
    @Autowired
    private Formatter twoFormatter;
    
    @Autowired
    private FormatterPrimary formatterPrimary; 
    
    // METHODS
    public void doStuff() {
    	
    	System.out.println("In doStuff(): calling fooFormatter.format()");
    	fooFormatter.format();
    	
    	System.out.println("In doStuff(): calling fooFormatter2.format()");
    	fooFormatter2.format();
    	
    	System.out.println("In doStuff(): calling myFormatter.format()");
    	String message = myFormatter.format();
    	System.out.println("In doStuff(): Output of calling myFormatter.format():" + message);
    		
    	System.out.println("In doStuff(): calling twoFormatter.format()");
    	message = twoFormatter.format();
    	System.out.println("In doStuff(): Output of calling twoFormatter.format():" + message);  
    	
    	System.out.println("In doStuff(): calling formatterPrimary.format()");
    	message = formatterPrimary.format();
    	System.out.println("In doStuff(): Output of calling formatterPrimary.format():" + message);  
    	
    }
}