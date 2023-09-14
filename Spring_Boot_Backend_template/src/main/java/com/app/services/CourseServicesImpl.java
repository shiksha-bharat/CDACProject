package com.app.services;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddCourseDTO;
import com.app.dto.AddStudentDTO;
import com.app.dto.CourseRespDTO;
import com.app.dto.RegisterDeskDTO;
import com.app.dto.StudentRespDTO;
import com.app.entities.Course;
import com.app.entities.Desks;
import com.app.entities.Institutes;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class CourseServicesImpl implements CourseServices{
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public CourseRespDTO getCourseFromCourseId(Long CourseId) {
		Course courseRes= courseRepo.findByCourseId(CourseId);
		
		return mapper.map(courseRes, CourseRespDTO.class);			
	}
	
	
	@Override
	public CourseRespDTO addNewCourse(AddCourseDTO dto) {
		
		Course course = mapper.map(dto, Course.class);
		course.setCourseId(dto.getCourseId());
		System.out.println("Course "+course.getCourseId());
				
		return mapper.map(courseRepo.save(course), CourseRespDTO.class);
	}
	
     
	@Override
	public CourseRespDTO updateCourse(Long courseId, AddCourseDTO dto) {
		Course course = courseRepo.findByCourseId(courseId);
		//.orElseThrow(() -> new ResourceNotFoundException("Invalid Emo ID , Emp not found !!!!"));
		mapper.map(dto, course);
		course.setCourseId(courseId);
		System.out.println("after mapping " + course);

		return mapper.map(course, CourseRespDTO.class);
	
	}	
	
}
