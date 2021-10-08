package com.niha.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.login.models.User;

@Repository 
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);

}
