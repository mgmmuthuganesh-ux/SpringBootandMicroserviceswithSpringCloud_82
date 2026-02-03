package com.training.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.dao.User;
import com.training.userservice.exception.UserNotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	List<User> userList = new ArrayList<>();

	@PostConstruct
	public void init() {
		userList.add(new User(1, "Vivek", "HYD", "vivek@gmail.com", "123456"));
		userList.add(new User(2, "Joe", "NYC", "joe@gmail.com", "123456"));
		userList.add(new User(3, "Chandler", "UTA", "chandler@gmail.com", "123456"));
		userList.add(new User(4, "Pheeebe", "NYC", "pheebe@gmail.com", "123456"));
		userList.add(new User(5, "Rachel", "Ohio", "rachel@gmail.com", "123456"));
		userList.add(new User(6, "Monika", "Dallas", "monika@gmail.com", "123456"));
		userList.add(new User(7, "Ross", "Dallas", "ross@gmail.com", "123456"));
	}

	public List<User> getAllUsers() {
		return userList;
	}

	public User getUserById(Integer uid) {
		return userList.stream().filter(usr -> usr.getUid() == uid).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User not found with id " + uid));
	}

	public User saveUser(User user) {
		userList.add(user);
		return getUserById(user.getUid());
	}

	public User updateUser(Integer uid, User user) {
		User existingUser = getUserById(uid);
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setAddress(user.getAddress() != null ? user.getAddress() : existingUser.getAddress());
		return existingUser;
	}

	public String deleteUser(Integer uid) {
		User user = getUserById(uid);
		userList.remove(user);
		return "User Deleted Successfully";
	}

}
