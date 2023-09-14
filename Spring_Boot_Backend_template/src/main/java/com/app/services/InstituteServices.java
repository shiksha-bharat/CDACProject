package com.app.services;

import com.app.dto.AddInstituteDTO;
import com.app.entities.Institutes;

public interface InstituteServices {
	
	public AddInstituteDTO addNewInstitute(AddInstituteDTO inst);
	
	public AddInstituteDTO getInstDetails(Long id);

}
