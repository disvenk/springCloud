package com.springcloud.orderfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//开启feign
@EnableCircuitBreaker
public class OrderFeginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFeginApplication.class, args);
	}

}
