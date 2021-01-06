package com.gm.metrics;

import com.codahale.metrics.MetricRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Configuration
    public class ServiceConfig {

    	
    	// This bean is needed as Springboot 2.x does not seem to support Autowiring of MetricRegistry without a Bean
    	// https://github.com/spring-projects/spring-boot/issues/11702
        @Bean
        public MetricRegistry getMetricsRegistry(){
            return new MetricRegistry();
        }
        
        
        /*  This bean is not needed as this class is in the same package
        @Bean
        public AppMetricRegistry getAppMetricsRegistry(){
            return new AppMetricRegistry();
        }
        */

    }
}
