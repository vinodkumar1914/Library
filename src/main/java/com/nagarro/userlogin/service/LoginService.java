package com.nagarro.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.userlogin.entity.User;
import com.nagarro.userlogin.repository.LoginRepository;

public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	public User getUserByUsername(String username) {
		return this.loginRepository.findByUsername(username);
	}
	
}
