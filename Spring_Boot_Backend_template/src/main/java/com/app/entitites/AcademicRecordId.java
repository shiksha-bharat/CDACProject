package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@Embeddable
public class AcademicRecordId{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rowId;

	//private Long uid;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE) 
	@JoinColumn(name = "uid")
	private StudentPersonalInfo studentPersonalInfo;
	
	@Column
	private Long academicyear;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "id")
	private Institutes institutesid;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "courseId")
	private Course courseid;
	
	



//	public Long getUid() {
//		return uid;
//	}
//
//	public void setUid(Long uid) {
//		this.uid = uid;
//	}
	
	
	
	



	public StudentPersonalInfo getStudentPersonalInfo() {
		return studentPersonalInfo;
	}

	public Long getAcademicYear() {
		return academicyear;
	}

	public void setAcademicYear(Long academicYear) {
		this.academicyear = academicYear;
	}


	public void setStudentPersonalInfo(StudentPersonalInfo studentPersonalInfo) {
		this.studentPersonalInfo = studentPersonalInfo;
	}

	


	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Institutes getInstitutesid() {
		return institutesid;
	}

	public void setInstitutesid(Institutes institutesid) {
		this.institutesid = institutesid;
	}

	public Course getCourseid() {
		return courseid;
	}

	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}

	@Override
	public String toString() {
		return "AcademicRecordId [rowId=" + rowId + ", studentPersonalInfo=" + studentPersonalInfo + ", academicyear="
				+ academicyear + ", institutesid=" + institutesid + ", courseid=" + courseid + "]";
	}

	


//	@Override
//	public String toString() {
//		return "AcademicRecordId [rowId=" + rowId + ", studentPersonalInfo=" + studentPersonalInfo + ", institutesid="
//				+ institutesid + ", courseid=" + courseid + ", result=" + result + "]";
//	}

//	@Override
//	public String toString() {
//		return "AcademicRecordId [rowId=" + rowId + ", uid=" + uid + ", institutesid=" + institutesid + ", courseid="
//				+ courseid + ", result=" + result + "]";
//	}
	
	
	
	

}
