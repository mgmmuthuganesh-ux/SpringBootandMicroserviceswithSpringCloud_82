package com.training.springbootstsdemo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class BalanceValidator implements Validator{
	
	@Override
	public void validate(int ammount) {
		int balance = 10000;
		if(ammount>0&&ammount<=balance) {
			System.out.println("=== Withdral Success == ");
			return;
		}
		System.out.println("=== Insufficient Balance ===");
	}
	
	
}
