package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;
import com.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping("/newuser")
	public String newUser() {
		return "NewUser";// jsp name
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {
		user.setRole("USER");

		user.setPassword(encoder.encode(user.getPassword()));

		userRepo.save(user); // insert users
		return "NewUser";
	}

	@GetMapping("/listusers")
	public String listUsers(Model model) {
		List<UserEntity> users = userRepo.findAll();
		model.addAttribute("users", users);
		return "ListUsers";
	}

}
