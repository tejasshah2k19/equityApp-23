package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;

@Controller
public class UserController {

	@GetMapping("/newuser")
	public String newUser() {
		return "NewUser";//jsp name 
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {
		user.setRole("USER");
		return "Login";
	}
}
