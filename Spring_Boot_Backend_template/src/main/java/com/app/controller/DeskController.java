package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddAcademicDTO;
import com.app.dto.AddInstituteDTO;
import com.app.dto.RegisterDeskDTO;
import com.app.dto.SignInDto;
import com.app.dto.StudentRespDTO;
import com.app.entities.Desks;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.DeskRepository;
import com.app.services.DeskServices;
import com.app.services.InstituteServices;

@RestController
@RequestMapping("/desk")
@CrossOrigin(origins = "*")
public class DeskController {
	@Autowired
	private DeskServices deskServices;
	
	@Autowired
	private DeskRepository deskRepository;
	
	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public ResponseEntity<?> addNewDept(@RequestBody  RegisterDeskDTO dto) {
		System.out.println("in add new dept " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(deskServices.addNewDesk(dto));
	}
	
	
	
	@GetMapping("/{deskId}")
	public RegisterDeskDTO getDeskByid(@PathVariable Long deskId) {
	    System.out.println("Getting desk with ID: " + deskId);
	    
	    Desks desk = deskRepository.findByDeskId(deskId);
	    
	    if (desk != null) {
	    	return mapper.map(desk, RegisterDeskDTO.class);
	    } else {
	        return null;
	    }
	}
	
	@PostMapping("/signin")
	public boolean signIn(@RequestBody @Valid SignInDto signInDto) {
		
		Desks desk = deskRepository.findByUsernameAndPassword(signInDto.getUsername(),signInDto.getPassword());
		if(desk.getUsername()!="") {
			System.out.println("true");		
			return true;
		}
		else {
			System.out.println("False");
			return false;
		}
	}
	
	    //@CrossOrigin(origins = "*")
	    @PostMapping("/{deskId}")
	    public ResponseEntity<Desks> updateDesks(@PathVariable long deskId,@RequestBody RegisterDeskDTO desksDetails) {
		 Desks updateDesks = deskRepository.findByDeskId(deskId);
//	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + deskId));
        System.out.println(desksDetails);
	    
	    updateDesks.setAutorityName(desksDetails.getAutorityName());
	    updateDesks.setUsername(desksDetails.getUsername());
	    updateDesks.setPassword(desksDetails.getPassword());
	    updateDesks.setPos(desksDetails.getPos());

	   
	    deskRepository.save(updateDesks);

	    return ResponseEntity.ok(updateDesks);
	}
}