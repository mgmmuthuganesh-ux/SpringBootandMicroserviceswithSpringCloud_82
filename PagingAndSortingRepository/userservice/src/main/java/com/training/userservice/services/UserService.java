package com.training.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.training.userservice.dao.User;
import com.training.userservice.dao.UsereRespository;
import com.training.userservice.exception.UserNotFoundException;


@Service
public class UserService {
	
	@Autowired
	UsereRespository repo;

	//size of page -> records per page
	// page number -> 0
	
	public List<User> getAllUsers(Integer pageNumber,Integer pagesize) {
		Pageable page = PageRequest.of(pageNumber, pagesize);
		Page<User> userPage = repo.findAll(page);
		return userPage.toList();
	}
	
	public List<User> getSortUsers(String sortkey,String sortOrder) {
		if(sortOrder.equalsIgnoreCase("desc")) {
			return repo.findAll(Sort.by(sortkey).descending());
		}
		return repo.findAll(Sort.by(sortkey));
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
