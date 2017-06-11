package com.fk.microservice.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *使用@EnableFeignClient开启Feign
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MovieFeignApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(MovieFeignApplication.class, args);
    }
}
