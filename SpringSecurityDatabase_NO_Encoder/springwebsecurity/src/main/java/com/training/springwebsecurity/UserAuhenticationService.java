package com.training.springwebsecurity;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.springwebsecurity.dao.UserInfo;
import com.training.springwebsecurity.dao.UserRepository;

@Service
public class UserAuhenticationService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo dbuser = repo.findByUsername(username).orElseThrow(()-> new RuntimeException("User Not avilabe"));
		User secureUser = new User(username, "{noop}"+dbuser.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("deummy")));
		return secureUser;
		
	}

}
