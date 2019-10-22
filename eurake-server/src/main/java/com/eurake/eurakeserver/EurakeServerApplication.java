package com.eurake.eurakeserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开启服务
//@EnableAdminServer //使用性能监控
@SpringBootApplication
public class EurakeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakeServerApplication.class, args);
	}
}
