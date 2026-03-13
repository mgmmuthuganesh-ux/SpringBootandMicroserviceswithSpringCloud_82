package com.training.keycloakspringboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	JwtConvertor jwtConvertor;

	@Bean
	public SecurityFilterChain initSecurity(HttpSecurity httpSecurity) {
		httpSecurity.authorizeHttpRequests(
				auth->auth.requestMatchers("/health").permitAll()
				.requestMatchers("/admin")
				//.hasAnyRole("ADMIN") // ROLE_ADMIN
				.hasAnyAuthority("admin")
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth->oauth.jwt(jwt->jwt.jwtAuthenticationConverter(jwtConvertor)))
		.logout(logout->logout.permitAll())
		.csrf((csrf) -> csrf.disable());
		
		return httpSecurity.build();
	}
}
