package com.app.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UpdateAcademicDto {
	private Double percentage;
	
	private boolean instituteStatus;
	
	private boolean courseStatus;

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

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "UpdateAcademicDto [percentage=" + percentage + ", instituteStatus=" + instituteStatus
				+ ", courseStatus=" + courseStatus + "]";
	}
	

}
