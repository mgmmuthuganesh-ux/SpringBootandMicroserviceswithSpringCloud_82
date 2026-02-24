package com.training.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/msg")
	public String sendMsg() {
		return "Hello There!!!";
	}
}
