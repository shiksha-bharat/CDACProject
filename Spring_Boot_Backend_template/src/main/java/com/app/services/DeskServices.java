package com.app.services;

import java.util.List;

import com.app.dto.AddStudentDTO;
import com.app.dto.RegisterDeskDTO;
import com.app.dto.StudentRespDTO;

public interface DeskServices {
	
	 RegisterDeskDTO addNewDesk(RegisterDeskDTO dto);
	 
	 List<RegisterDeskDTO> getAllDesk(Long id);
	 
	 RegisterDeskDTO updateDesk(Long id, RegisterDeskDTO dto);
    
}
