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
import com.training.userservice.dto.OrderDto;
import com.training.userservice.dto.UserDto;
import com.training.userservice.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService service;
	
	@GetMapping("/greet")
	public String greetOrder() {
		return service.greetfromOrder();
	}
	
	@GetMapping("/orders/{uid}")
	public UserDto getOrders(@PathVariable Integer uid) {
		return service.getUserwithOrders(uid);
	}
	
	@PostMapping("/order/save")
	public UserDto saveOrder(@RequestBody OrderDto order) {
		return service.placeOrder(order);
	}
	
	
	@PostMapping(value="/greet",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> greet(@RequestBody Object reqbody) {
		return  ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("msg","header message")
				.body(reqbody);
	}
	
	@GetMapping(value="/all/{pagesize}/{pageNubmer}")
	public ResponseEntity<List<User>> getAllUsers(@PathVariable(required = false) int pagesize,@PathVariable(required = false) int pageNubmer){
		pagesize = pagesize<0?pagesize:10;
		
		
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(service.getAllUsers(pageNubmer,pagesize));
	}
	
	@GetMapping(value="/all/sort/{sortkey}/{sortOrder}")
	public ResponseEntity<List<User>> getAllUsersBySort(@PathVariable String sortkey,@PathVariable String sortOrder){
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(service.getSortUsers(sortkey,sortOrder));
	}
		
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUser(@PathVariable Integer uid) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("msg", "header message");
		return new ResponseEntity<User>(service.getUserById(uid),headers,HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name) {
		return new ResponseEntity<User>(service.getUserByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/addr/{address}")
	public ResponseEntity<List<User>> getUserByAddress(@PathVariable String address) {
		return new ResponseEntity<List<User>>(service.getUserAdress(address),HttpStatus.OK);
	}
	
	@GetMapping("/email/{mail}")
	public ResponseEntity<List<User>> getUserByEMail(@PathVariable String mail) {
		return new ResponseEntity<List<User>>(service.getUserByEmail(mail),HttpStatus.OK);
	}
	
	@GetMapping("/addrcount/{addr}")
	public ResponseEntity<Integer> getUserCountByAddr(@PathVariable String addr) {
		return new ResponseEntity<Integer>(service.getUserCountByAdress(addr),HttpStatus.OK);
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
