package com.training.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.training.userservice.dao.Course;
import com.training.userservice.dao.Hobby;
import com.training.userservice.dao.User;
import com.training.userservice.dao.UsereRespository;
import com.training.userservice.dto.OrderDto;
import com.training.userservice.dto.UserDto;
import com.training.userservice.exception.UserNotFoundException;

import jakarta.transaction.Transactional;


@Service
@Transactional // Decalarative Transactions
public class UserService {
	
	@Autowired
	UsereRespository repo;
	
	@Qualifier("orderserviceclient")
	@Autowired
	RestClient client;
	
	
	public String greetfromOrder() {
		return client.get().uri("/greet").retrieve().body(String.class); 
	}
	
	public List<OrderDto> getOrdersByUid(Integer id) {
		return client.get().uri("/uid/{id}",id).retrieve().body(List.class);
	}

	
	public UserDto placeOrder(OrderDto order) {
		OrderDto dto = client.post().uri("/save").body(order).retrieve().body(OrderDto.class);
		return getUserwithOrders(order.getUid());
	}
	
	public UserDto getUserwithOrders(Integer uid) {
		
		List<OrderDto> orders = getOrdersByUid(uid);
		User u =  getUserById(uid);
		
		UserDto userDto = new UserDto();
		userDto.setEmail(u.getEmail());
		userDto.setName(u.getName());
		userDto.setOrders(orders);
		userDto.setUid(u.getUid());
		return userDto;
	}
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
	
	public User getUserByName(String name) {
		return repo.findByName(name)
				.orElseThrow(()-> new UserNotFoundException("User Not Found "+ name));
	}

	public List<User> getUserAdress(String addr) {
		return repo.findByAddress(addr);
	}
	
	public List<User> getUserByEmail(String email) {
		return repo.findByEmailContaining(email);
	}
	
	public Integer getUserCountByAdress(String addr) {
		return repo.findUserCountByAdress(addr);
	}
	
	
	public User saveUser(User user) {
		user.getHobbies().stream().forEach(h->h.setUser(user));
		// save some
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
