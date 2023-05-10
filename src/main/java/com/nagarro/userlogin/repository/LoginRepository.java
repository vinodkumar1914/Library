package com.nagarro.userlogin.repository;


import org.springframework.data.repository.CrudRepository;

import com.nagarro.userlogin.entity.User;

public interface LoginRepository  extends CrudRepository<User, String>{
		public User findByUsername(String username);
}