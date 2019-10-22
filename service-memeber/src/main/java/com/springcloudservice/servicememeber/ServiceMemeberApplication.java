package com.springcloudservice.servicememeber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class ServiceMemeberApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMemeberApplication.class, args);
	}
}
