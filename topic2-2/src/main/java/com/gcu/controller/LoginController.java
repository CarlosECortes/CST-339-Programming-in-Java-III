package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String showLoginForm(Model model) {
	    model.addAttribute("loginModel", new LoginModel());
	    return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(
	        @jakarta.validation.Valid com.gcu.model.LoginModel loginModel,
	        org.springframework.validation.BindingResult bindingResult,
	        org.springframework.ui.Model model) {
		
		// If there are validation errors, retunr to the login page
		if (bindingResult.hasErrors()) {
			//ensure the same attribute name the form expects
			model.addAttribute("loginModel", loginModel);
			return "login";
		}
		
		//Sample data
		java.util.List<com.gcu.model.OrderModel> orders = java.util.Arrays.asList(
			new com.gcu.model.OrderModel(1L, "A1001", "Sword of Destiny", 199.99f, 1),
			new com.gcu.model.OrderModel(2L, "A1002", "Mjolnir", 49.99f, 2),
			new com.gcu.model.OrderModel(3L, "A1003", "Blade of Truth", 29.99f, 4)
				
		);
		
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		
		return "orders";  // templates/orders.html
	}

}
