package com.training.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	OpenAPI configDoc() {
		
		OpenAPI opapi = new OpenAPI();
		Info info = new Info();
		info.setTitle("UserSevice");
		info.setDescription("An api to Perform User CRUD Operatiosn with Order api");
		info.setVersion("1.0.1");
		opapi.info(info);
		return opapi;
	}

}
