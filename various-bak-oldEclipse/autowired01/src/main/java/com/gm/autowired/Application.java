package com.gm.autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
class Application {
    public static void main(String[] args) {
        
    	// This is if you want a web server
    	//SpringApplication.run(Application.class, args);
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        FooService fooService = ctx.getBean(FooService.class);
        fooService.doStuff();
    }
}
