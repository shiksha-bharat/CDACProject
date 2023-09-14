package com.app.services;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddStudentDTO;
import com.app.dto.StudentRespDTO;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServicesImpl implements StudentServices{
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public StudentRespDTO getStudentsFromUid(Long uid) {
		StudentPersonalInfo studentRes= studentRepo.findByUid(uid);
		
		
				return mapper.map(studentRes, StudentRespDTO.class);
				
	}

	public StudentRespDTO addNewStudent(AddStudentDTO dto) {

		// validate confirm password --o.w throw the exc
		StudentPersonalInfo student = mapper.map(dto, StudentPersonalInfo.class);
		student.setUid(dto.getUid());
	System.out.println("student "+student.getUid());
		
			return mapper.map(studentRepo.save(student), StudentRespDTO.class);
//		} else
//				System.out.println("error to insert new student... incorrect password");
//			// new ApiException("Passwords don't match!!!!!");
//			return null;

	}

	public StudentRespDTO updateStudent(Long uid, AddStudentDTO dto) {
		// validate if emp exists by id
		StudentPersonalInfo student = studentRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emo ID , Emp not found !!!!"));
		// => emp exists
		// validate confirm password
//		if (dto.getPassword().equals(dto.getConfirmPassword())) {
//			
			// dto contains the updates , so apply it --> to entity
			mapper.map(dto, student);// but after this id : null
			student.setUid(uid);;// so setting it again
			System.out.println("after mapping " + student);

			return mapper.map(student, StudentRespDTO.class);
		//}
		//throw new ApiException("Passwords don't match");

	}
	
	@Override
	public StudentRespDTO getStudentDetails(Long uid) {
		StudentPersonalInfo student = studentRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid ID!!!"));
//		if (employee.getDept().getId() != deptId)
//			throw new ResourceNotFoundException("Dept id does not match !!!");
		return mapper.map(student, StudentRespDTO.class);
	}

	@Override
	public StudentRespDTO transferStudent(Long uid) {
		StudentPersonalInfo student = studentRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid ID!!!"));
		return null;
	}


	
	
}
