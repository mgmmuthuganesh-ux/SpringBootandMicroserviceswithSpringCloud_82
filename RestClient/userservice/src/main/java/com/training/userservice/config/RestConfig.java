package com.training.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfig {
	
	@Value("${order.service.uri}")
	String orderUri;
	
	@Autowired
	LoggingInterceptor interceptor;

	@Bean("orderservice")
	RestClient initRestClient1() {
		return RestClient.builder()
				.baseUrl(orderUri).build();
	}
	
	@Bean("invoiceservice")
	RestClient initRestClient2() {
		return RestClient.builder().baseUrl("http://localhost:7070/invoice")
				.build();
	}
	
}
