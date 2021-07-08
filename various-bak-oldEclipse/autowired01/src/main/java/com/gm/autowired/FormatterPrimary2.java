package com.gm.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FormatterPrimary2 implements FormatterPrimary {
	
	public String format() {
		
		return "Primary Two";
	}

}
