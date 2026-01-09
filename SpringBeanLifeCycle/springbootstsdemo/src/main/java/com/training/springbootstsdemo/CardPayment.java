package com.training.springbootstsdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name="payment.type",havingValue = "card")
@Primary
@Component("card")
public class CardPayment implements PaymentProcessor{

	@Override
	public String payment() {
		return "Card Payment Success";
	}

}
