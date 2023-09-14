package com.app.controller;

import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddInstituteDTO;
import com.app.dto.RegisterDeskDTO;
import com.app.entities.Desks;
import com.app.entities.Institutes;
import com.app.repository.DeskRepository;
import com.app.repository.InstitutesRepository;
import com.app.services.InstituteServices;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/institute")
@CrossOrigin(origins = "*")

public class InstituteController {
	

		@Autowired
		private InstituteServices instituteServices;

		@Autowired
		private InstitutesRepository instituteRepository;
		
		@Autowired
		private ModelMapper mapper;

		
		@PostMapping
		public ResponseEntity<?> addNewDept(@RequestBody  AddInstituteDTO dto) {
			System.out.println("in add new dept " + dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(instituteServices.addNewInstitute(dto));
		}
		

		
		@GetMapping("/{id}")
		public Optional<Institutes> getDeskByid(@PathVariable Long id) {
		    System.out.println("Getting inst with ID: " + id);
		    
		    Optional<Institutes> inst = instituteRepository.findById(id);
		    System.out.println(inst);
		    
		    	//return mapper.map(inst, AddInstituteDTO.class);
		    return inst;
		    
		}
		@PostMapping("/{id}")
	    public ResponseEntity<Institutes> updateInstitute(@PathVariable long id,@RequestBody Institutes instituteDetails) {
			Institutes updateInstitute = instituteRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

			updateInstitute.setId(instituteDetails.getId());
			updateInstitute.setName(instituteDetails.getName());
			updateInstitute.setAddress(instituteDetails.getAddress());
			updateInstitute.setCity(instituteDetails.getCity());
			updateInstitute.setState(instituteDetails.getState());
			updateInstitute.setPincode(instituteDetails.getPincode());
			updateInstitute.setUniversity(instituteDetails.getUniversity());

	   
			instituteRepository.save(updateInstitute);

	    return ResponseEntity.ok(updateInstitute);
	}

		




}
