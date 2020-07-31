package com.spiegelberger.springmvc.security.thymeleaf.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLogin")
	public String showLogin() {
		
		return "login-page";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
	
}
