package com.nagarro.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.userlogin.entity.User;
import com.nagarro.userlogin.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody User user) {
		User authenticatedUser = this.loginService.getUserByUsername(user.getUsername());
		
		if (authenticatedUser != null && authenticatedUser.getPassword().equals(user.getPassword())) {
			return new ResponseEntity<User>(authenticatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
}
