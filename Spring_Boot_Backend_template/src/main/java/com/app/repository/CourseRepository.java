package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.GetStudByInst;
import com.app.entities.Course;
import com.app.entities.StudentPersonalInfo;


public interface CourseRepository extends JpaRepository<Course, Long>{
	
   Course findByCourseId(Long courseId);
   
   
}
