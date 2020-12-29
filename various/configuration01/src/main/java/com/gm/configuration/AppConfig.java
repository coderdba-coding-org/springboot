package com.gm.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.gm")
@PropertySource(value = "application.properties")
public class AppConfig {

    @Bean
    public H2Configurer databaseConfig() {
        return new H2Configurer();
    }
}