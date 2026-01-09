package com.training.springbootstsdemo;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private Integer pid;
	private String name;
	private Integer price;
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	

}
