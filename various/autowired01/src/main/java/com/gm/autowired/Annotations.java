package com.gm.autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Annotations {
	
	@Qualifier
	@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FormatterTypeQualifer {  
	    String value();
	}
	
}
