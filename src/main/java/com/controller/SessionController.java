package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.LoginDto;
import com.entity.UserEntity;
import com.repository.UserRepository;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping("login")
	public String login() {
		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(LoginDto login, Model model) {

		UserEntity user = userRepo.findByEmail(login.getEmail());
		if (user != null) {
			if (encoder.matches(login.getPassword(), user.getPassword()) == true) {
				if (user.getRole().equals("USER")) {
					return "Home";
				} else if (user.getRole().equals("ADMIN")) {
					return "Dashboard";
				}
			}
		}

		model.addAttribute("error", "Invalid Credentials...");

		return "Login";
	}
}
