package com.gm.scheduled;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		

			//ORIGINAL CODE: originally, only this line was coded - WHICH IS SUFFICIENT
			//SpringApplication.run(Application.class);
			
			// ALTERNATE: Capture context and display beans or other stuff from it
			// This part of beans is just to print info - not core need
			// NOTE: Here, running the application and also capturing its context
		    ApplicationContext ctx = SpringApplication.run(Application.class, args);

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
	}

}
