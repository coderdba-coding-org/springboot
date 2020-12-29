package com.gm.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Application  {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
    
        Application app = ctx.getBean(Application.class);
    
        app.run();
        ctx.close();
  
        staticRun();
    }
    
    private void run() {
    	System.out.println("In Application class, running run()");
    } 
    
    private static void staticRun() {
    	System.out.println("In Application class, running staticRun()");
    } 
}