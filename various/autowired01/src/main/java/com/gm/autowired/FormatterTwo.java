package com.gm.autowired;

import org.springframework.stereotype.Component;

@Component("twoFormatter")
public class FormatterTwo implements Formatter {
	
	public String format() {
		
		return "Two";
	}

}
