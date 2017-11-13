package com.rainier.gc.system.gc.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.json.UserRequest;
import com.rainier.gc.system.gc.model.User;
import com.rainier.gc.system.gc.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	
	public void registerUser(UserRequest userRequest){
		User user = new User();
		user.setDateOfBirth(userRequest.getDateOfBirth());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setMobileNumber(userRequest.getMobileNumber());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setEmailAddress(userRequest.getEmailAddress());
		user.setLoginTime(new Date());
		user.setLastAccess(new Date());
		user.setStatus(userRequest.getStatus());
	}
	
	
}
