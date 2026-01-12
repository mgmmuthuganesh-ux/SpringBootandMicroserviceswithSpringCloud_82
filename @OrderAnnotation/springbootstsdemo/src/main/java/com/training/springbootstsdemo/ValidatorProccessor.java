package com.training.springbootstsdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ValidatorProccessor {
	
	@Autowired
	List<Validator> valList;

	public void doValidation() {
		for(Validator vl:valList) {
			vl.validate(1500);
		}
		
	}
	
}
