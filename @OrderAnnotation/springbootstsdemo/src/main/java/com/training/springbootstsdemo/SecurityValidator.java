package com.training.springbootstsdemo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class SecurityValidator implements Validator{

	@Override
	public void validate(int ammount) {
		System.out.println("=== Security Validation Completed ===");
		return;
	}
	
}
