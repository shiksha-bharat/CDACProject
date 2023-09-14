package com.app.controller;

import java.time.LocalDate;
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
import com.app.dto.AcademicDetailRespDTO;
import com.app.dto.AddAcademicDTO;
import com.app.dto.StudentRespDTO;
import com.app.dto.UpdateAcademicDto;
import com.app.entities.StudentAcademicDetails;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.AcademicDetailsRepository;
import com.app.services.AcademicDetailsServices;

@RestController
@RequestMapping("/academic")
@CrossOrigin(origins = "*")
public class AcademicController {

	@Autowired
	private AcademicDetailsServices academicDetailsService;
	
	@Autowired
	private AcademicDetailsRepository academicDetailRepository;
	
	@GetMapping("/")
	public void getDetails() {
		System.out.println("in get details ");
		
	}
	
		
	@GetMapping("/{uid}")
	public ResponseEntity<StudentAcademicDetails> getDetailsByUidAndAcademicYear(@PathVariable StudentPersonalInfo uid) {
		System.out.println("in get details " + uid);
//		StudentAcademicDetails studentAcademicDetails = academicDetailRepository.findByStudentPersonalInfoAndAcademicyear(uid,academicyear);
		StudentAcademicDetails studentAcademicDetails = academicDetailRepository.findByStudentPersonalInfo(uid);

		System.out.println(studentAcademicDetails);
		return ResponseEntity.ok(studentAcademicDetails);
		
	}
	
	
	@PostMapping
	public ResponseEntity<?> addDetails(@RequestBody @Valid AddAcademicDTO dto) {
		System.out.println("in add details " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(academicDetailsService.addNewDetails(dto));
	}

	
	 @PostMapping("/{uid}/{id}/{courseid}/{academicyear}")
	    public ResponseEntity<StudentAcademicDetails> updateStudent(@PathVariable Long uid, Long id, Long courseid, Long academicyear,@RequestBody UpdateAcademicDto updateAcademicDto) {
		 StudentAcademicDetails updateAcademicDetails = academicDetailRepository.findStudentAcademicRecord(uid,id,courseid,academicyear);
//	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + uid));
System.out.println(updateAcademicDto);
		 updateAcademicDetails.setPercentage(updateAcademicDto.getPercentage());
		 updateAcademicDetails.setInstituteStatus(updateAcademicDto.isInstituteStatus());
		 updateAcademicDetails.setCourseStatus(updateAcademicDto.isCourseStatus());
	 
		 academicDetailRepository.save(updateAcademicDetails);
		 
		 return ResponseEntity.ok(updateAcademicDetails);
	    }
	
		@GetMapping("/inst/{id}")
		public ResponseEntity<?> getStudentById(@PathVariable Long id) {
			System.out.println("in get students " + id);
			List<StudentRespDTO> list = academicDetailsService.getAllStudentsFromInstId(id);
			list.forEach(System.out::println);
			System.out.println(list.isEmpty());
			if (list.isEmpty())
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			return ResponseEntity.ok(list);
		}



}
