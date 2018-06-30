package com.rks.usermanagement.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.rks.usermanagement.rest.model.User;

import rx.Observable;

@RestController
public class UserController {
	
	@GetMapping(value = "/users")
	public DeferredResult<List<User>> getUsers(){
		List<User> users = new ArrayList<>();
		
		for(int i = 0; i<10; i++){
			users.add(new User("id"+i, "name"+i, "role"+i));
		}
		
		Observable<List<User>> o = Observable.from(users).toList();
	    DeferredResult<List<User>> deffered = new DeferredResult<>(90000L);
	    o.subscribe(m -> deffered.setResult(m), e -> deffered.setErrorResult(e));
	    return deffered;
	}

}
