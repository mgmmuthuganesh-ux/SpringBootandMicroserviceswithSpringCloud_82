package com.training.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;
import com.training.userservice.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService service;
	
	
	@PostMapping(value="/greet",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> greet(@RequestBody Object reqbody) {
		return  ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("msg","header message")
				.body(reqbody);
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(defaultValue = "json") String format){
		
		MediaType media = format.contains("xml")?MediaType.APPLICATION_XML:MediaType.APPLICATION_JSON;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("count", service.getAllUsers().size()+"");
		return ResponseEntity
		.status(HttpStatus.OK)
		.contentType(media)
		.headers(headers)
		.body(service.getAllUsers());
	}
		
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUser(@PathVariable Integer uid) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("msg", "header message");
		return new ResponseEntity<User>(service.getUserById(uid),headers,HttpStatus.OK);
	}
	
	@GetMapping("/param")
	public ResponseEntity<User> getUserRequestaparam(@RequestParam Integer uid) {
		return new ResponseEntity<User>(service.getUserById(uid),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		return new ResponseEntity<User>(service.saveUser(u),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable int uid,@RequestBody User user) {
		return new ResponseEntity<User>(service.updateUser(uid, user),HttpStatus.CREATED);
	}
	
	@PatchMapping("/updatefeild/{uid}")
	public ResponseEntity<User> updateUserFeild(@PathVariable int uid,@RequestBody User user) {
		return new ResponseEntity<User>(service.updateUser(uid, user),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer uid) {
		return new ResponseEntity<String>(service.deleteUser(uid),HttpStatus.OK);
	}
	
}
