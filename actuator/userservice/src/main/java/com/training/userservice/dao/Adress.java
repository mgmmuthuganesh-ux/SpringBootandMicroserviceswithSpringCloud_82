package com.training.userservice.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adrid;
	private String city;
	private String state;
	
	@Column(unique = true)
	private Integer zip;
	
	
	
	public Integer getAdrid() {
		return adrid;
	}
	public void setAdrid(Integer adrid) {
		this.adrid = adrid;
	}
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
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	
	
	
	
	
}
