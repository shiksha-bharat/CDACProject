package com.admin.admin_micro.services;

import com.admin.admin_micro.dto.GetCredentialsDto;
import com.admin.admin_micro.entities.AdminLogin;

public interface AdminServices {

	public AdminLogin findAdminByUsernameAndPassword(GetCredentialsDto getCredentialDto);
}
