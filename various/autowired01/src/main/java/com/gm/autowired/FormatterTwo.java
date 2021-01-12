package com.gm.autowired;

import org.springframework.stereotype.Component;

//this is the custom annotation created in Annotations.java
import com.gm.autowired.Annotations.FormatterTypeQualifer;

@Component("twoFormatter")
@FormatterTypeQualifer("Two")  // additional custom-qualifer
public class FormatterTwo implements Formatter {
	
	public String format() {
		
		return "Two";
	}

}
