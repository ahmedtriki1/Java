package com.koukou.LoginResgister.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.koukou.LoginResgister.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// FIND USER BY EMAIL
    Optional<User> findByEmail(String email);

}