package com.mynotes.spring.cloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}

}

@Component
class RibbonRunner implements CommandLineRunner {
	@Autowired
	LoadBalancerClient loadBalancer;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside Ribbon Runner");
		ServiceInstance instance = loadBalancer.choose("user-service");
		System.out.println("=======RIBBON=================");
		System.out.println("URI==>>" + instance.getUri());

	}

}

@Component
class RestTemplateRunner implements CommandLineRunner {
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {
		
		String result = restTemplate.getForObject("http://user-service/users/getPublicMailingAddress", String.class);
		System.out.println("=======RestTemplate=================");
		System.out.println("RESULT===>" + result);

	}
}
