package com.training.springwebsecurity.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Integer>{

	Optional<UserInfo> findByUsername(String username);
}
