package com.training.springwebsecurity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.springwebsecurity.dao.UserInfo;
import com.training.springwebsecurity.dao.UserRepository;

@Service
public class UserAuhenticationService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	//ROLE -> ADMIN -> hasRole(ROLE_ADMIN)
	// ROLE-> USER -> hasRole(ROLE_USER)
	//Authority -> ADMIN -> hasAutherity(ADMIN)

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo dbuser = repo.findByUsername(username).orElseThrow(()-> new RuntimeException("User Not avilabe"));
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		dbuser.getRoles().stream().forEach(role->{
			authorities.add(()->role.getRole().name());
		});
		
		User secureUser = new User(username, dbuser.getPassword(),authorities);
		return secureUser;
		
	}

}
