package com.training.springhibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/all")
	public List<User> getAllUser(){
		return dao.getAllUser();
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User usr) {
		return dao.saveUser(usr);
	}
	
	@GetMapping("/{uid}")
	public User getUser(@PathVariable Integer uid) {
		return dao.getUserId(uid);
	}
	
	@PutMapping("/{uid}")
	public User updateUser(@PathVariable Integer uid, @RequestBody User u) {
		return dao.updateUser(uid, u);
	}
	
	@DeleteMapping("/{uid}")
	public String deleteUser(@PathVariable Integer uid) {
		return dao.deleteUser(uid);
	}
}

