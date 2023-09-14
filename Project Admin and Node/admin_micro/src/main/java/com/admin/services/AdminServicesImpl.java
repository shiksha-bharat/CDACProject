package com.admin.admin_micro.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.admin_micro.dto.GetCredentialsDto;
import com.admin.admin_micro.entities.AdminLogin;
import com.admin.admin_micro.repository.AdminRepository;

@Service
@Transactional
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public AdminLogin findAdminByUsernameAndPassword(GetCredentialsDto getCredentialDto) {
		AdminLogin adminLogin = adminRepository.findByUsernameAndPassword(getCredentialDto.getUsername(), getCredentialDto.getPassword());
		return adminLogin;
	}

}
