package org.training.springbootstsdemo;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private Integer iod;
	private String status;
	
	
	public Integer getIod() {
		return iod;
	}
	public void setIod(Integer iod) {
		this.iod = iod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Order [iod=" + iod + ", status=" + status + "]";
	}
	
	
}
