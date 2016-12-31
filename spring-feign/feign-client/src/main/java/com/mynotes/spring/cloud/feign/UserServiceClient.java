package com.mynotes.spring.cloud.feign;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mynotes.spring.cloud.service.Groups;



@FeignClient("user-service")
public interface UserServiceClient {

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String userDetails(@PathVariable("userId") int userId);
	
	@RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
	public List<Groups> getAllGroups();

}