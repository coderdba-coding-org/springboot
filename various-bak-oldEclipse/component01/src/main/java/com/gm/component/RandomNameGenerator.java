package com.gm.component;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// This can be @Service for better notation
// But, Component and Service are not really different, and this example is to demo Component
@Component
public class RandomNameGenerator {

    public String generate() {

    	// var does not work in Java 8 - so, commenting out the code originally from the reference
    	// Also, List.of does not seem to be in Java 8
    	
    	// var names = List.of("Peter", "Roland", "Lucy", "Robert", "Jane");
    	// var r = new Random();

        List<String> names = Arrays.asList("Peter", "Roland", "Lucy", "Robert", "Jane");
        
        Random r = new Random();
    	int i = r.nextInt(names.size());

        return names.get(i);
    }
}
