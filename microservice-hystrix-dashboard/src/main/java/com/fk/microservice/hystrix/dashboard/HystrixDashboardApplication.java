package com.fk.microservice.hystrix.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication 
{
    public static void main( String[] args )
    {
		new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
    }
}
