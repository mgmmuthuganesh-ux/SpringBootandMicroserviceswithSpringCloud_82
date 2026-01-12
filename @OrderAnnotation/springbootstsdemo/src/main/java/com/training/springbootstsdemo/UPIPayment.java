package com.training.springbootstsdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name="payment.type",havingValue = "upi")
@Qualifier("upi")
@Component()
public class UPIPayment implements PaymentProcessor{

	@Override
	public String payment() {
		return "UPI Payment Success";
	}
	
}
