package com.training.springhibernatedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springhibernatedemo.dao.User;
import com.training.springhibernatedemo.dao.UserDao;
import com.training.springhibernatedemo.dao.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao dao;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User usr) {
		return dao.saveUser(usr);
	}
	
	@GetMapping("/{uid}")
	public UserDto getUser(@PathVariable Integer uid) {
		return dao.getUserId(uid);
	}
}

