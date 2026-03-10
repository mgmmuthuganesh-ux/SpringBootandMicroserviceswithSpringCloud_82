package com.training.springwebsecurity.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springwebsecurity.dao.Role;
import com.training.springwebsecurity.dao.RoleRepository;
import com.training.springwebsecurity.dao.Roles;
import com.training.springwebsecurity.dao.UserDto;
import com.training.springwebsecurity.dao.UserInfo;
import com.training.springwebsecurity.dao.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	PasswordEncoder encode;
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	RoleRepository roleRepo;
	

	@GetMapping("/hello")
	public String greet() {
		return "Hello From user Controller";
	}
	
	@PostMapping("/save")
	public UserInfo saveUser(@RequestBody UserDto u) {
		
		UserInfo user = new UserInfo();
		user.setUsername(u.getUsername());
		user.setPassword(encode.encode(u.getPassword()));
		
		Set<String> payloadroles = u.getRoles();
		
		Set<Roles> roles = new HashSet<Roles>();
		
		payloadroles.stream().forEach(role->{
			Roles userRoles = roleRepo.findByRole(Role.valueOf(role))
			.orElseThrow(()->new RuntimeException("ROLE NOT FOUND "+ role));
			roles.add(userRoles);
		});
		user.setRoles(roles);
		return repo.save(user);
		
		
		
	}
	
}
