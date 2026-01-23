package com.training.springmvcthymleafpos.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private Integer pid;
	private String name;
	private String status;
	private Integer qty;
	
	public Product() {
		
	}
	
	public Product(Integer pid, String name, String status, Integer qty) {
		this.pid = pid;
		this.name = name;
		this.status = status;
		this.qty = qty;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
