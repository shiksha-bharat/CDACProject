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
import org.springframework.web.client.RestTemplate;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddStudentDTO;
import com.app.dto.SignInDto;
import com.app.dto.StudentRespDTO;
import com.app.dto.StudentSignInDto;
import com.app.entities.Desks;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.AcademicDetailsRepository;
import com.app.repository.StudentRepository;
import com.app.services.AcademicDetailsServices;
import com.app.services.StudentServices;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")

public class StudentController {
	
	@Autowired
	private StudentServices studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/")
	public void getStudents() {
		System.out.println("in get students ");
		
	}
	@GetMapping("/{uid}")
	public StudentRespDTO getStudentByUid(@PathVariable Long uid) {
		System.out.println("in get students " + uid);
		StudentRespDTO studentRespDTO = studentService.getStudentsFromUid(uid);
		String pwdStatus = this.restTemplate.getForObject("http://127.0.0.1:9999/pwdstatus/uid", String.class );
		studentRespDTO.setPwdStatus(pwdStatus);
		return studentRespDTO;
	}
	

	
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody @Valid AddStudentDTO dto) {
		System.out.println("in add student " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addNewStudent(dto));
	}
	
	 @PostMapping("{uid}")
	    public ResponseEntity<StudentPersonalInfo> updateStudent(@PathVariable long uid,@RequestBody StudentPersonalInfo studentDetails) {
		 StudentPersonalInfo updateStudent = studentRepository.findById(uid)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + uid));
		 System.out.println(studentDetails);
		 updateStudent.setFirstName(studentDetails.getFirstName());
		 updateStudent.setMiddleName(studentDetails.getMiddleName());
		 updateStudent.setLastName(studentDetails.getLastName());
		 updateStudent.setFatherName(studentDetails.getFatherName());
		 updateStudent.setMotherName(studentDetails.getMotherName());
		 updateStudent.setDob(studentDetails.getDob());
		 updateStudent.setGender(studentDetails.getGender());
		 updateStudent.setReligion(studentDetails.getReligion());
		 updateStudent.setAddress(studentDetails.getAddress());
		 updateStudent.setCountry(studentDetails.getCountry());
		 updateStudent.setState(studentDetails.getState());
		 updateStudent.setCity(studentDetails.getCity());
		 updateStudent.setZipCode(studentDetails.getZipCode());
		 updateStudent.setEmail(studentDetails.getEmail());
		 //updateStudent.setPassword(studentDetails.getPassword());

		 studentRepository.save(updateStudent);

	        return ResponseEntity.ok(updateStudent);
	    }
	 
	 
	 @PostMapping("/signin")
		public boolean signIn(@RequestBody @Valid StudentSignInDto StudentSignInDto) {
			
			StudentPersonalInfo student = studentRepository.findByEmailAndPassword(StudentSignInDto.getEmail(),StudentSignInDto.getPassword());
			if(student.getEmail()!="") {
				System.out.println("true");		
				return true;
			}
			
			else
			{
				System.out.println("False");
				return false;
			}
		}
}
