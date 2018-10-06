package com.mynotes.microservice.spring.admin.userservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(new String[] { "user1", "user2", "user3" });
	}

}
