package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.UserRepository;
import com.entity.UserEntity;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/newuser")
	public String newUser() {
		return "NewUser";// jsp name
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {
		user.setRole("USER");
		userRepo.save(user); // insert users
		return "NewUser";
	}

	@GetMapping("/listusers")
	public String listUsers(Model model) {
		List<UserEntity> users = userRepo.findAll();
		model.addAttribute("users",users);
		return "ListUsers";
	}

}
