package com.gm.component;


import com.gm.component.RandomNameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.boot.CommandLineRunner;


@Component
public class MyRunner implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private RandomNameGenerator randGenerator;

    @Override
    public void run(String... args) {
        
        logger.info("Generating random name: {}", randGenerator.generate());
        logger.info("Generating random name: {}", randGenerator.generate());
        logger.info("Generating random name: {}", randGenerator.generate());
    }
}