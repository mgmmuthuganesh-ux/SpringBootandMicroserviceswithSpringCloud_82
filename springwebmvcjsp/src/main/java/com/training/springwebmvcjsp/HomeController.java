package com.training.springwebmvcjsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/greet")
	public String greet() {
		return "greet";
	}
	
}
