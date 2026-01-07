package com.training.springbootstsdemo;

import org.springframework.stereotype.Component;

@Component
public class Adress {

	private String city;
	private String state;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Adress [city=" + city + ", state=" + state + "]";
	}
	
	
	
}
