package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Desks;
import com.app.entities.Institutes;
import com.app.entities.StudentPersonalInfo;

public interface DeskRepository extends JpaRepository<Desks, Long>{
	
	Desks findByDeskId(Long deskId);
	
    Desks findByUsernameAndPassword(String username, String password);
}
