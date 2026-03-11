package com.training.springwebsecurity.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.training.springwebsecurity.dao.Role;


public interface RoleRepository extends CrudRepository<Roles, Integer>{
	

	public Optional<Roles> findByRole(Role role);
}
