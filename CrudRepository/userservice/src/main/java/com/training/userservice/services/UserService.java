package com.training.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.userservice.dao.User;
import com.training.userservice.dao.UsereRespository;
import com.training.userservice.exception.UserNotFoundException;


@Service
public class UserService {
	
	@Autowired
	UsereRespository repo;


	public List<User> getAllUsers() {
		return (List<User>) repo.findAll();
	}

	public User getUserById(Integer uid) {
		return repo.findById(uid)
				.orElseThrow(()-> new UserNotFoundException("User Not Found "+ uid));
	}

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUser(Integer uid, User user) {
		User existingUser = getUserById(uid);
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setAddress(user.getAddress() != null ? user.getAddress() : existingUser.getAddress());
		return repo.save(existingUser);
		
	}

	public String deleteUser(Integer uid) {
		repo.deleteById(uid);
		return "User Deleted Successfully";
	}

}
