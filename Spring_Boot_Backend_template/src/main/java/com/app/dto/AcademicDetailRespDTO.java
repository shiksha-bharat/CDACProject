package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.AcademicRecordId;
import com.app.entities.Course;
import com.app.entities.Institutes;
import com.app.entities.StudentPersonalInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class AcademicDetailRespDTO {
	
	
	//@JsonProperty(access = Access.READ_ONLY)
	private Long uid;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long institutesid;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long courseid;
	
	//@NotBlank
	private boolean status;
	
	
	private double percentage;
	
	
	private LocalDate academicYear;
	
	
	private String result;
	
	public Long getUid() {
		return uid;
	}
	
	
	public void setUid(Long uid) {
		this.uid = uid;
	}
	

	public Long getInstitutesid() {
		return institutesid;
	}


	public void setInstitutesid(Long institutesid) {
		this.institutesid = institutesid;
	}


	public Long getCourseid() {
		return courseid;
	}


	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public LocalDate getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(LocalDate academicYear) {
		this.academicYear = academicYear;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "AcademicDetailRespDTO [ uid=" + uid + ", institutesid=" + institutesid
				+ ", courseid=" + courseid + ", status=" + status + ", percentage=" + percentage + ", academicYear="
				+ academicYear + ", result=" + result + "]";
	}
	
}
