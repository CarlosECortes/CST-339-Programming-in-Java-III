package com.gcu.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginModel {
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be 3-20 characters")
	private String username;
	
	@NotBlank(message = "Password is required")
	@Size(min = 6, max = 20, message = "Password must be 3-20 characters")
	private String password;
	
	public LoginModel() { }
	
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

}
