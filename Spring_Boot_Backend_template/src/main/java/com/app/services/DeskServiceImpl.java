package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.RegisterDeskDTO;
import com.app.dto.StudentRespDTO;
import com.app.entities.Desks;
import com.app.entities.Institutes;
import com.app.entities.StudentPersonalInfo;
import com.app.repository.DeskRepository;
import com.app.repository.InstitutesRepository;

@Service
@Transactional
public class DeskServiceImpl implements DeskServices{
	
	@Autowired
	private InstitutesRepository instRepo;
	
	@Autowired
	private DeskRepository deskRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public RegisterDeskDTO addNewDesk(RegisterDeskDTO dto) {
		
		Institutes inst = instRepo.findById(dto.getInst_id()).
				orElseThrow();
		

		Desks desk = mapper.map(dto, Desks.class);
		inst.addDesks(desk);//cascade on save
		
		return mapper.map(deskRepo.save(desk), RegisterDeskDTO.class);
	}

//	@Override
//	public List<RegisterDeskDTO> getAllDesk(Long id) {
//		List<Desks> deskList= deskRepo.findByid(id);
//		deskList.forEach(System.out::println);
//		return deskList.stream()
//				.map(emp -> mapper.map(emp,RegisterDeskDTO.class))
//				.collect(Collectors.toList());
//	}

	@Override
	public RegisterDeskDTO updateDesk(Long id, RegisterDeskDTO dto) {
		Desks desk = deskRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emo ID , Emp not found !!!!"));
		mapper.map(dto, desk);// but after this id : null
		desk.setDeskId(id);;// so setting it again
		System.out.println("after mapping " + desk);

		return mapper.map(desk, RegisterDeskDTO.class);
	//}
	//throw new ApiException("Passwords don't match");
	}

	@Override
	public List<RegisterDeskDTO> getAllDesk(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
