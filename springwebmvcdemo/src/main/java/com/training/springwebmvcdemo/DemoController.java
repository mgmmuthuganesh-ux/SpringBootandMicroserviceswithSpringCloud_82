package com.training.springwebmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/demo")
	public String greet() {
		return "greet";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
