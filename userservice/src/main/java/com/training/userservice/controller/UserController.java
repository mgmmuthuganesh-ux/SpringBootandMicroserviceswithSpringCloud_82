package com.training.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {

	List<User> userList = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		userList.add(new User(1,"Vivek","HYD","vivek@gmail.com"));
		userList.add(new User(2,"Joe","NYC","joe@gmail.com"));
		userList.add(new User(3,"Chandler","UTA","chandler@gmail.com"));
		userList.add(new User(4,"Pheeebe","NYC","pheebe@gmail.com"));
		userList.add(new User(5,"Rachel","Ohio","rachel@gmail.com"));
		userList.add(new User(6,"Monika","Dallas","monika@gmail.com"));
		userList.add(new User(7,"Ross","Dallas","ross@gmail.com"));
	}
	
	@RequestMapping("/greet")
	public String greet() {
		return "greet";
	}
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userList;
	}
		
	@RequestMapping("/user/{uid}")
	public User getUser(@PathVariable Integer uid) {
		return userList.stream().filter(usr->usr.getUid()==uid).findFirst().orElse(null);
	}
	
	@RequestMapping("/user")
	public User getUserRequestaparam(@RequestParam Integer uid) {
		return userList.stream().filter(usr->usr.getUid()==uid).findFirst().orElse(null);
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public User saveUser(@RequestBody User u) {
		userList.add(u);
		return userList.stream().filter(usr->usr.getUid()==u.getUid()).findFirst().orElse(null);
	}
	
	
	@RequestMapping(value = "/update/{uid}",method = RequestMethod.PUT)
	public User updateUser(@PathVariable int uid,@RequestBody User user) {
		User existingUser = userList.stream().filter(usr->usr.getUid()==uid).findFirst().orElse(null);
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		existingUser.setAddress(user.getAddress()!=null?user.getAddress():existingUser.getAddress());
		return existingUser;
	}
	
	@RequestMapping(value = "/updatefeild/{uid}",method = RequestMethod.PATCH)
	public User updateUserFeild(@PathVariable int uid,@RequestBody User user) {
		User existingUser = userList.stream().filter(usr->usr.getUid()==uid).findFirst().orElse(null);
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		existingUser.setAddress(user.getAddress()!=null?user.getAddress():existingUser.getAddress());
		return existingUser;
	}
	
	@RequestMapping(value = "/delete/{uid}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer uid) {
		User existingUser = userList.stream()
				.filter(usr->usr.getUid()==uid).findFirst().orElse(null);
		if(existingUser==null) {
			return "User Not Found";
		}
		userList.remove(existingUser);
		return "User Deleted Successfully";
		
	}
	
	
	
}
