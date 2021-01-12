package com.gm.autowired;

import org.springframework.stereotype.Component;

@Component("oneFormatter")
public class FormatterOne implements Formatter {
	
	public String format() {
		
		return "One";
	}

}
