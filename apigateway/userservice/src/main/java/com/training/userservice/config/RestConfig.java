package com.training.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;


@Configuration
public class RestConfig {
	
	@Value("${order.service.uri}")
	String orderUri;
	
	@Autowired
	LoggingInterceptor interceptor;
	
	@Bean
	@Primary
	RestClient.Builder defaultBuilder(){
		return RestClient.builder();
	}
	
	@LoadBalanced
	@Bean("lbrestclient")
	RestClient.Builder lbBuilder(){
		return RestClient.builder();
	}
	
	
		
	@Bean("orderservice")
	RestClient initRestClient1(@Qualifier("lbrestclient")RestClient.Builder builder) {
		return 	builder.requestInterceptor(interceptor)
				.baseUrl(orderUri).build();
	}
	
	@Bean("invoiceservice")
	RestClient initRestClient2() {
		return RestClient.builder().baseUrl("http://localhost:7070/invoice")
				.requestInterceptor(interceptor).build();
	}
	
	
}
