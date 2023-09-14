package com.app.services;

import java.util.List;

import com.app.dto.AddStudentDTO;
import com.app.dto.StudentRespDTO;

public interface StudentServices {
	StudentRespDTO getStudentsFromUid(Long uid);

	StudentRespDTO addNewStudent(AddStudentDTO dto);
	
	StudentRespDTO updateStudent(Long uid, AddStudentDTO dto);

	StudentRespDTO getStudentDetails(Long uid);
	
	StudentRespDTO transferStudent(Long uid);
	
	
	
	
}
