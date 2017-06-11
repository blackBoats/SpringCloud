package com.fk.microservice.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MovieRibbonApplication 
{
	/*
	 * 实例化RestTemplate 通过@LoadBalanced注解开启负载均衡能力
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(MovieRibbonApplication.class, args);
    }
}
