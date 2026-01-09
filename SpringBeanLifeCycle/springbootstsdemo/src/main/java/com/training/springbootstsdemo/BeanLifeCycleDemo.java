package com.training.springbootstsdemo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BeanLifeCycleDemo {

	public BeanLifeCycleDemo() {
		System.out.println("******** 1. Constructer ********");
	}
	
	@PostConstruct
	void postConstrucDemo() {
		System.out.println("******** 2. PostConstruct ********");
	}
	
	void doSomething() {
		System.out.println("******** 3. DoSomething ********");
	}
	
	@PreDestroy
	void PreDestroyDemo() {
		System.out.println("******** 4. PreDestroy ********");
	}
	
}
