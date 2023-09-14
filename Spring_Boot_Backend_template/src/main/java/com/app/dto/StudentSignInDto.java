package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class StudentSignInDto {
	
	@NotBlank(message = "Email can't be blank")
	@Email
	private String email;
//	@NotBlank
	@Length(min = 5,max=20,message = "Invalid password length")
	private String password;
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
	
	@Override
	public String toString() {
		return "StudentSignInDto [email=" + email + ", password=" + password + "]";
	}
	
	
	
}