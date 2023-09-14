package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddCourseDTO;
import com.app.dto.CourseRespDTO;
import com.app.entities.Course;
import com.app.repository.CourseRepository;
import com.app.services.CourseServices;


@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {
	
	@Autowired
	private CourseServices courseService;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@GetMapping("/")
	public void getCourses() {
		System.out.println("in get Courses ");
		
	}
	@GetMapping("/{courseId}")
	public CourseRespDTO getCourseByUid(@PathVariable Long courseId) {
		System.out.println("in get Courses " + courseId);
		CourseRespDTO courseRespDTO = courseService.getCourseFromCourseId(courseId);
		
		return courseRespDTO;
	}
	
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody  AddCourseDTO dto) {
		System.out.println("in add course " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addNewCourse(dto));
	}
	
	 @PostMapping("/{courseId}")
	    public ResponseEntity<Course> updateStudent(@PathVariable long courseId,@RequestBody Course courseDetail) {
		 Course updateCourse = courseRepository.findByCourseId(courseId);
	//                .orElseThrow(() -> new ResourceNotFoundException("Course not exist with id: " + courseId));
        System.out.println(courseDetail);
		 updateCourse.setCourseId(courseDetail.getCourseId());
		 updateCourse.setCourseName(courseDetail.getCourseName());
		 updateCourse.setMedium(courseDetail.getMedium());
		 updateCourse.setDurationYear(courseDetail.getDurationYear());
		
		 
		 courseRepository.save(updateCourse);

	        return ResponseEntity.ok(updateCourse);
	    }
}
