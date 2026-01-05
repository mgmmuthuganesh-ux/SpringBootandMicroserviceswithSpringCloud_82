package com.training.springbootstsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.training.springbootstsdemo.Order;

import com.training.springbootstsdemo.invoice.Report;

@SpringBootApplication
@ComponentScan(basePackages = {"com.training.springbootstsdemo","org.training.springbootstsdemo"})
public class SpringbootstsdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(SpringbootstsdemoApplication.class, args);
		Order o = ioc.getBean(Order.class);
		o.setIod(123);
		o.setStatus("delivered");
		System.out.println(o);

		
	}

}
