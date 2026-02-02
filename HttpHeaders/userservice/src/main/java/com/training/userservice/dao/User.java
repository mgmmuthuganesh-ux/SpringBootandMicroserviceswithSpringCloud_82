package com.training.userservice.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class User {

	private Integer uid;
	private String name;
	private String address;
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	public User(Integer uid, String name, String address, String email, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
