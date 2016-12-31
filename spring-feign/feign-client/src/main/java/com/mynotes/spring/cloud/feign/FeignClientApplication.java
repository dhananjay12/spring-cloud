package com.mynotes.spring.cloud.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mynotes.spring.cloud.service.Groups;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}

}

@Component
class FeignRunner1 implements CommandLineRunner {
	@Autowired
	UserServiceClient userServiceClient;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=================START FeignRunner1 Runner=============================");
		String result=userServiceClient.userDetails(5);
		System.out.println("=========FEIGN RESULT userDetails===>" + result);
		List<Groups> groups=userServiceClient.getAllGroups();
		System.out.println("=========FEIGN RESULT getAllGroups===>" + groups.size());
		System.out.println("=================EXIT FeignRunner1 Runner==============================");
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
		
		String result = restTemplate.getForObject("http://user-service/user/1", String.class);
		System.out.println("=======RestTemplate=================");
		System.out.println("RestTemplate RESULT===>" + result);

	}
}
