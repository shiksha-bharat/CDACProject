package com.app.services;

import java.util.List;

import com.app.dto.AcademicDetailRespDTO;
import com.app.dto.AddAcademicDTO;
import com.app.dto.StudentRespDTO;
import com.app.entities.AcademicRecordId;
import com.app.entities.StudentAcademicDetails;



public interface AcademicDetailsServices {
	

	AddAcademicDTO addNewDetails(AddAcademicDTO dto);

	List<AcademicDetailRespDTO> getAllDetailsFromUid(Long uid);
	
	List<StudentRespDTO> getAllStudentsFromInstId(Long id);
	
}
