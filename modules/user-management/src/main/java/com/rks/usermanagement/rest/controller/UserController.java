package com.rks.usermanagement.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rks.usermanagement.rest.model.User;

@RestController
public class UserController {
	
	@GetMapping(value = "/users")
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		
		for(int i = 0; i<10; i++){
			users.add(new User("id"+i, "name"+i, "role"+i));
		}
		
		return users;
	}

}
