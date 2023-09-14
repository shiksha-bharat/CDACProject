package com.app.entities;

import java.time.LocalDate;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "studentacademicdetails")
public class StudentAcademicDetails extends AcademicRecordId {
	
	@Column(length=10)
	private boolean instituteStatus;
	
	@Column(length=	10)
	private boolean courseStatus;
	
	@Column(length=20,name="percentage")
	private double percentage;
	
	
	public StudentAcademicDetails() 
	{
		super();
		
	}     

	
	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public boolean isInstituteStatus() {
		return instituteStatus;
	}


	public void setInstituteStatus(boolean instituteStatus) {
		this.instituteStatus = instituteStatus;
	}


	public boolean isCourseStatus() {
		return courseStatus;
	}


	public void setCourseStatus(boolean courseStatus) {
		this.courseStatus = courseStatus;
	}


	@Override
	public String toString() {
		return "StudentAcademicDetails [instituteStatus=" + instituteStatus + ", courseStatus=" + courseStatus
				+ ", percentage=" + percentage + "]";
	}

	

	}
	
	
