package com.app.dto;

import com.app.entities.StudentPersonalInfo;

public class GetStudByInst {
	private StudentPersonalInfo studentPersonalInfo;

	public StudentPersonalInfo getStudentPersonalInfo() {
		return studentPersonalInfo;
	}

	public void setStudentPersonalInfo(StudentPersonalInfo studentPersonalInfo) {
		this.studentPersonalInfo = studentPersonalInfo;
	}

	@Override
	public String toString() {
		return "GetStudByInst [studentPersonalInfo=" + studentPersonalInfo + "]";
	}
	
}
