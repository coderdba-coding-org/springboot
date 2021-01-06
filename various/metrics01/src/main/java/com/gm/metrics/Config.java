package com.gm.metrics;

import com.codahale.metrics.MetricRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Configuration
    public class ServiceConfig {

        @Bean
        public MetricRegistry getMetricsRegistry(){
            return new MetricRegistry();
        }
        
        @Bean
        public AppMetricRegistry getAppMetricsRegistry(){
            return new AppMetricRegistry();
        }

    }
}
