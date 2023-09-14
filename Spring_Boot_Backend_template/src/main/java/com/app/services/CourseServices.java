package com.app.services;

import java.util.List;

import com.app.dto.AddCourseDTO;
import com.app.dto.AddStudentDTO;
import com.app.dto.CourseRespDTO;
import com.app.dto.StudentRespDTO;

public interface CourseServices {
	CourseRespDTO getCourseFromCourseId(Long courseId);

	CourseRespDTO addNewCourse(AddCourseDTO dto);
	
	CourseRespDTO updateCourse(Long courseId, AddCourseDTO dto);

//	StudentRespDTO getStudentDetails(Long uid);
	
	
	
	
	
}
