package com.mynotes.spring.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceRestController {
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserDetails(@PathVariable("id") int id) {
		
		return "User details for id " +id;
	}
	
	@RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
	@ResponseBody
	public List<Groups> getAllGroups() {
		List<Groups> groups=new ArrayList<Groups>();
		groups.add(new Groups(1, "Groups1"));
		groups.add(new Groups(2, "Groups2"));
		groups.add(new Groups(3, "Groups3"));
		return groups;
	}
	

}
