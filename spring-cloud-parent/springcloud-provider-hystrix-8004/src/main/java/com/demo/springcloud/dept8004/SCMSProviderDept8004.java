package com.demo.springcloud.dept8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 启用Eureka客户端功能，让当前微服务可以在Eureka中注册服务信息也可以获取服务信息——服务注册和发现
@EnableCircuitBreaker
public class SCMSProviderDept8004 {
	
	public static void main(String[] args) {
		SpringApplication.run(SCMSProviderDept8004.class, args);
	}

}