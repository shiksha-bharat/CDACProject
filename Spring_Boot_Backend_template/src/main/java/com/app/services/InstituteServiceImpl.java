package com.app.services;

import java.util.Optional;

import org.apache.catalina.mapper.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dto.AddInstituteDTO;
import com.app.entities.Institutes;
import com.app.repository.InstitutesRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InstituteServiceImpl implements InstituteServices {
	@Autowired
	private InstitutesRepository instRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AddInstituteDTO addNewInstitute(AddInstituteDTO inst) {
		System.out.println("in inst " + inst);
		Institutes InstituteEntity = mapper.map(inst, Institutes.class);
		
		System.out.println("in InstituteEntity" + InstituteEntity);
		Institutes persistentDept = instRepo.save(InstituteEntity);
		return mapper.map(persistentDept, AddInstituteDTO.class);
	}
	
	@Override
	public AddInstituteDTO getInstDetails(Long id) {
//		Institutes inst = instRepo.findById(id).
//		orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
		Optional<Institutes> inst = instRepo.findById(id);
//				orElseThrow();
		return mapper.map(inst,AddInstituteDTO.class);
		
	}
}
