package com.training.billmanagerapp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BillmanagerappApplication {

    private final BillingProcessor billingProcessor;

    BillmanagerappApplication(BillingProcessor billingProcessor) {
        this.billingProcessor = billingProcessor;
    }

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(BillmanagerappApplication.class, args);
		Order order = ioc.getBean(Order.class);
		order.placeOrder();
		
	}

}
