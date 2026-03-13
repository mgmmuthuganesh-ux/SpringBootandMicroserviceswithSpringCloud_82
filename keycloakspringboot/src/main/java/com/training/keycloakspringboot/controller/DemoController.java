package com.training.keycloakspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/health")
	public String health() {
		return "Service Up";
	}
	
	
	@GetMapping("/user")
	public String userapi() {
		return "User API Called";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Admin API Called";
	}
	
	
}
