package com.admin.admin_micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.admin_micro.entities.AdminLogin;

public interface AdminRepository extends JpaRepository<AdminLogin, String>{
	
	AdminLogin findByUsernameAndPassword(String username, String password);

}
