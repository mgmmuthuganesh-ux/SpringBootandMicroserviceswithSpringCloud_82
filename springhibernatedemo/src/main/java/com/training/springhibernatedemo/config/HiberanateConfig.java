package com.training.springhibernatedemo.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HiberanateConfig {

	// SessionFactory->metadata->ssr->config
	
	@Bean
	public SessionFactory initSession() {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(sr).getMetadataBuilder().build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		return sf;
	}
	
	
}
