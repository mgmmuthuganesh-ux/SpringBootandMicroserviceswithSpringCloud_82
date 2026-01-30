package com.training.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;
import com.training.userservice.exception.UserNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController {

	List<User> userList = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		userList.add(new User(1,"Vivek","HYD","vivek@gmail.com","123456"));
		userList.add(new User(2,"Joe","NYC","joe@gmail.com","123456"));
		userList.add(new User(3,"Chandler","UTA","chandler@gmail.com","123456"));
		userList.add(new User(4,"Pheeebe","NYC","pheebe@gmail.com","123456"));
		userList.add(new User(5,"Rachel","Ohio","rachel@gmail.com","123456"));
		userList.add(new User(6,"Monika","Dallas","monika@gmail.com","123456"));
		userList.add(new User(7,"Ross","Dallas","ross@gmail.com","123456"));
	}
	
	@RequestMapping("/greet")
	public ResponseEntity<String> greet() {
		return new ResponseEntity<String>("Hello There!!!!", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
		
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUser(@PathVariable Integer uid) {
		User user = userList.stream()
				.filter(usr->usr.getUid()==uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User not found with id " + uid));
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/param")
	public ResponseEntity<User> getUserRequestaparam(@RequestParam Integer uid) {
		User user = userList.stream()
				.filter(usr->usr.getUid()==uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User not found with id " + uid));
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		userList.add(u);
		User saveduser = userList.stream().filter(usr->usr.getUid()==u.getUid()).findFirst().orElse(null);
		return new ResponseEntity<User>(saveduser,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable int uid,@RequestBody User user) {
		User existingUser = userList.stream()
				.filter(usr->usr.getUid()==uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User not found with id " + uid));
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		existingUser.setAddress(user.getAddress()!=null?user.getAddress():existingUser.getAddress());
		return new ResponseEntity<User>(existingUser,HttpStatus.CREATED);
	}
	
	@PatchMapping("/updatefeild/{uid}")
	public ResponseEntity<User> updateUserFeild(@PathVariable int uid,@RequestBody User user) {
		User existingUser = userList.stream()
				.filter(usr->usr.getUid()==uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User not found with id " + uid));
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		existingUser.setAddress(user.getAddress()!=null?user.getAddress():existingUser.getAddress());
		return new ResponseEntity<User>(existingUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer uid) {
		User existingUser = userList.stream()
				.filter(usr->usr.getUid()==uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User not found with id " + uid));
		userList.remove(existingUser);
		return new ResponseEntity<String>("User Deleted Successfully",HttpStatus.OK);
	}
	
	
	
}
