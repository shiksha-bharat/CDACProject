package com.admin.admin_micro.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class GetCredentialsDto {
	@NotBlank(message = "Username can't be blank")
	private String username;
//	@NotBlank
	@Length(min = 5,max=20,message = "Invalid password length")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SignInDto [username=" + username + ", password=" + password + "]";
	}
	
}
