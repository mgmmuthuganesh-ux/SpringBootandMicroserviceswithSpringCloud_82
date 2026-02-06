package com.training.springhibernatedemo.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class User {
	
	@Id
	private Integer uid;
	private String name;
	private String addr;
	private String contact;
	
	public User() {
		
	}
	
	public User(Integer uid, String name, String addr, String contact) {
		this.uid = uid;
		this.name = name;
		this.addr = addr;
		this.contact = contact;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
