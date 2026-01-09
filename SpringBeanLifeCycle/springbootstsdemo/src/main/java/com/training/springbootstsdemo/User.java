package com.training.springbootstsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	private Integer id;
	private String name;

	private Adress addr;
	
	@Autowired
	private PaymentProcessor pr;
	
	@Autowired
	public User(Adress addr) {
		this.addr = addr;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Adress getAddr() {
		return addr;
	}
	
	
	
	public void setAddr(Adress addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return  name  + " made " + pr.payment();
	}

	

	
	
	

	
	
	
	
}
