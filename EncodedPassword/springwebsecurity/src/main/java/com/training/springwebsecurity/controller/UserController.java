package com.training.springwebsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springwebsecurity.dao.UserInfo;
import com.training.springwebsecurity.dao.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	PasswordEncoder encode;
	
	@Autowired
	UserRepository repo;

	@GetMapping("/hello")
	public String greet() {
		return "Hello From user Controller";
	}
	
	@PostMapping("/save")
	public UserInfo saveUser(@RequestBody UserInfo u) {
		u.setPassword(encode.encode(u.getPassword()));
		return repo.save(u);
	}
	
}
