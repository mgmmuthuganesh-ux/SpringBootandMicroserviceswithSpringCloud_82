package com.training.springbootstsdemo;

import org.springframework.stereotype.Component;


@Component
public class User {
	private Integer id;
	private String name;
	private String addr;
	
	public User() {
		System.out.println("User Object Created");
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
