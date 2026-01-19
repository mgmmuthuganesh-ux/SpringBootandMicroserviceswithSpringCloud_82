package com.training.springwebmvcdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {

	
	@Bean
	ViewResolver init() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/views/");
		view.setSuffix(".html");
		return view;
	}
	
}
