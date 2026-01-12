package com.training.springbootstsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.training.springbootstsdemo","org.training.springbootstsdemo"})
public class SpringbootstsdemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(SpringbootstsdemoApplication.class, args);
		ValidatorProccessor bean = ioc.getBean(ValidatorProccessor.class);
		bean.doValidation();
	}

}
