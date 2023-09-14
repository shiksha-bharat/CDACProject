package com.admin.admin_micro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.admin_micro.dto.GetCredentialsDto;
import com.admin.admin_micro.entities.AdminLogin;
import com.admin.admin_micro.repository.AdminRepository;
import com.admin.admin_micro.services.AdminServices;

@RestController
@RequestMapping("/adminlogin")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminServices adminServices;
	@CrossOrigin
	@PostMapping("/signin")
	public boolean signIn(@RequestBody @Valid GetCredentialsDto getCredentialsDto) {
		
		AdminLogin adminLogin = adminServices.findAdminByUsernameAndPassword(getCredentialsDto);
		if(adminLogin.getUsername()!="") {
			System.out.println("true");		
			return true;
		}
		else {
			System.out.println("False");
			return false;
		}
	}

}
