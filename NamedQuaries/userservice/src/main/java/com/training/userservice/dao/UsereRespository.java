package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsereRespository extends JpaRepository<User, Integer>{

	Optional<User> findByName(String name);
	
	List<User> findByAddress(String address);
	
	List<User> findByEmailContaining(String email);
	
	
	@Query(value = "select count(*) from user where address=:address",nativeQuery = true)
	Integer findUserCountByAdress(String address);
}
