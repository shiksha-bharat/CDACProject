package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.GetStudByInst;
import com.app.entities.Desks;
import com.app.entities.StudentPersonalInfo;


public interface StudentRepository extends JpaRepository<StudentPersonalInfo, Long>{
	
   StudentPersonalInfo findByUid(Long uid);
   
   StudentPersonalInfo findByEmailAndPassword(String email, String password);
   
   
}
