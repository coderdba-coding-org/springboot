package com.gm.configuration;

import com.gm.configuration.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

    	// var is not in Java8
        // var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // var app = ctx.getBean(Application.class);

    	// Instead of var, use these constructs
    	// NOTE: in the "ctx =" step, instead of AppConfig.class, we can use Application.class also
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	Application app = ctx.getBean(Application.class);
    	
    	// Runs the run() in this class itself
    	// If it is private static void run() then ctx, app etc steps are not necessary
        app.run();

        ctx.close();
    }

    @Value("${app.name}")
    private String applicationName;

    @Value("${app.db}")
    private String database;

    private void run() {

        logger.info("Application name: {}", applicationName);
        logger.info("Database: {}", database);

    }
}