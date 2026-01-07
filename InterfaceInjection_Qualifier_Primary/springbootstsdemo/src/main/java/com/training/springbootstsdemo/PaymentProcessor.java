package com.training.springbootstsdemo;

import org.springframework.stereotype.Component;

@Component
public interface PaymentProcessor {

	public String payment();
}
