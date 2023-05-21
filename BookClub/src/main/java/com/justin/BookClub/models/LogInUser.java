package com.justin.BookClub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LogInUser {
	@NotEmpty(message="Field Required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Field required!")
	@Size(min=8,message="Must be at least 8 characters!")
	private String password;
	
	public LogInUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
