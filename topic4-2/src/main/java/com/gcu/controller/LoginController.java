package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;




@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
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
		
		// If there are validation errors, return to the login page
		if (bindingResult.hasErrors()) {
			//ensure the same attribute name the form expects
			model.addAttribute("loginModel", loginModel);
			return "login";
		}
		
		service.test();
		
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
				

		return "orders";  // templates/orders.html
	}

}
