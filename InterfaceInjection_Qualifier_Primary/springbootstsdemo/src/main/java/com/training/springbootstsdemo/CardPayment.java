package com.training.springbootstsdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("card")
public class CardPayment implements PaymentProcessor{

	@Override
	public String payment() {
		return "Card Payment Success";
	}

}
