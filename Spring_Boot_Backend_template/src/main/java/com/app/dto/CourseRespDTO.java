package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.app.entities.Institutes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



public class CourseRespDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long courseId;
	
	@NotBlank
	private String courseName;
	@NotBlank
	private String medium;
	@NotBlank
	private String durationYear;
	
	

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getDurationYear() {
		return durationYear;
	}

	public void setDurationYear(String durationYear) {
		this.durationYear = durationYear;
	}

	

	@Override
	public String toString() {
		return "CourseRespDTO [courseId=" + courseId + ", courseName=" + courseName + ", medium=" + medium
				+ ", durationYear=" + durationYear + "]";
	}
		
}
