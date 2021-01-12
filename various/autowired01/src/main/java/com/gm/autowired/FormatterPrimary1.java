package com.gm.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class FormatterPrimary1 implements FormatterPrimary {
	
	public String format() {
		
		return "Primary One";
	}

}
