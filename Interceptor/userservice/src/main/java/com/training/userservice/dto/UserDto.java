package com.training.userservice.dto;

import java.util.List;

import com.training.userservice.dao.Adress;
import com.training.userservice.dao.Course;
import com.training.userservice.dao.Hobby;

public class UserDto {

	private Integer uid;
	private String name;
	private String email;
	
	public List<OrderDto> orders;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	
	
}
