package com.training.billmanagerapp;

public class Item {

	public String name;
	public Integer price;
	
	public Item(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
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
	
	@Override
	public String toString() {
		return "name=" + name + ", price=" + price;
	}
	
	
	
	
	
}
