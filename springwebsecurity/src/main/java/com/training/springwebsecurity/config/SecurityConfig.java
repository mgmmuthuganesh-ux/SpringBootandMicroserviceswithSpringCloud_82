package com.training.springwebsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain configSecurity(HttpSecurity httpSecurity) {
		httpSecurity.authorizeHttpRequests(auth->auth.requestMatchers("/hello","/home","/home.html").permitAll()
				.anyRequest().authenticated())
		.formLogin(formlogin->formlogin.permitAll())
		.logout(logout->logout.permitAll());
		
		
		return httpSecurity.build();
		
	}

}
