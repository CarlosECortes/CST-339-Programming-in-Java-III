package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// Map the root URL "/" to the home view
	@GetMapping("/")
	public String home() {
		return "home"; // resolve to src/main/resources/templates/home.html
	}
}