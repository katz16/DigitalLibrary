package com.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
	private UserService userService;
	@PostMapping
	public User addNewUser(@RequestBody User u) {
		return userService.addNewUser(u);
	}
	
}