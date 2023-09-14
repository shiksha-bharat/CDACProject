package com.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.dto.GetStudByInst;
import com.app.entities.AcademicRecordId;
import com.app.entities.StudentAcademicDetails;
import com.app.entities.StudentPersonalInfo;

@Repository
public interface AcademicDetailsRepository extends JpaRepository<StudentAcademicDetails, Long>{
	

	@Query("select e from StudentAcademicDetails e where e.studentPersonalInfo.uid= :uid")
	List<StudentAcademicDetails> findByUid(Long uid);
	
	@Query("select e from StudentAcademicDetails e where e.studentPersonalInfo.uid= :uid"+" AND e.institutesid.id= :id "+ "AND e.courseid.courseId= :courseid "+ "AND e.academicyear= :academicyear")
	StudentAcademicDetails findStudentAcademicRecord(@Param("uid")Long uid,@Param("id")Long id,@Param("courseid")Long courseid,@Param("academicyear")Long academicyear);
	
//	@Query("select e from StudentAcademicDetails e where e.studentPersonalInfo = :uid"+" AND e.academicyear= :academicyear")
//	StudentAcademicDetails findByStudentPersonalInfoAndAcademicyear(@Param("uid")StudentPersonalInfo uid,@Param("academicyear")Long academicyear);
	@Query("select e from StudentAcademicDetails e where e.studentPersonalInfo = :uid")
	StudentAcademicDetails findByStudentPersonalInfo(@Param("uid")StudentPersonalInfo uid);


	
	List<StudentAcademicDetails> findAllByInstitutesid(Long id);
	
}
