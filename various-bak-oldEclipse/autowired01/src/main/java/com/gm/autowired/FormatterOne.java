package com.gm.autowired;

import org.springframework.stereotype.Component;

// this is the custom annotation created in Annotations.java
import com.gm.autowired.Annotations.FormatterTypeQualifer;

@Component("oneFormatter")
@FormatterTypeQualifer("One")  // additional custom-qualifer
public class FormatterOne implements Formatter {
	
	public String format() {
		
		return "One";
	}

}
