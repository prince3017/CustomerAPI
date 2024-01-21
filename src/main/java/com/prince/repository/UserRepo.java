package com.prince.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prince.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String emaill);

}
