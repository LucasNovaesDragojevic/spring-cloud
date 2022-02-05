package com.store.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class BeansGenerator 
{
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
