package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AcademicDetailRespDTO;
import com.app.dto.AddAcademicDTO;
import com.app.dto.AddStudentDTO;
import com.app.dto.StudentRespDTO;
import com.app.entities.AcademicRecordId;
import com.app.entities.StudentAcademicDetails;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.AcademicDetailsRepository;


@Service
@Transactional
public class AcademicDetailServiceImpl implements AcademicDetailsServices{

	@Autowired
	private AcademicDetailsRepository academicDetailsRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public List<AcademicDetailRespDTO> getAllDetailsFromUid(Long uid) {
		
		List<StudentAcademicDetails> detailsList= academicDetailsRepo.findByUid(uid);
		detailsList.forEach(System.out::println);
		return detailsList.stream()
				.map(emp -> mapper.map(emp, AcademicDetailRespDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public AddAcademicDTO addNewDetails(AddAcademicDTO dto) {
		StudentAcademicDetails studentAcademicDetailsEntity = mapper.map(dto, StudentAcademicDetails.class);
		StudentAcademicDetails persistentStudentAcademicDetails = academicDetailsRepo.save(studentAcademicDetailsEntity);
		return mapper.map(persistentStudentAcademicDetails, AddAcademicDTO.class);
	}
	
	@Override
	public List<StudentRespDTO> getAllStudentsFromInstId(Long id) {
		
		List<StudentAcademicDetails> student = academicDetailsRepo.findAllByInstitutesid(id);
				//.orElseThrow(() -> new ResourceNotFoundException("Invalid ID!!!"));
//		if (employee.getDept().getId() != deptId)
//			throw new ResourceNotFoundException("Dept id does not match !!!");
		return (List<StudentRespDTO>) mapper.map(student, StudentRespDTO.class);
	}
	
	
}
