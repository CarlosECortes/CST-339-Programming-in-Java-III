package com.gcu;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class MyService {
	
	@GetMapping("/test")
	public String test(Principal principal) {
		
		// principal.getName() gives the GitHub username once authenticated
		return "Hello " + principal.getName() + " and welcome to my protected service!!";
	}

}
