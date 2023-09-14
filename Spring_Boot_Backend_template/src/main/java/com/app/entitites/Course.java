package com.app.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

import lombok.NoArgsConstructor;



@Entity
@Table(name="course")
@NoArgsConstructor
public class Course {
	
	@Id
	@Column(name="course_id", insertable=true, updatable=true, unique=true, nullable=false)
	private Long courseId;
	
	@Column(length = 30)
	private String courseName;
	
	@Column(length = 30)
	private String medium;
	
	@Column
	private int durationYear;
	
//	@Autowired
//	@ManyToMany(mappedBy = "course", fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
//	private List<Institutes> inst;
	
//	@Autowired
//	@OneToMany(mappedBy = "courseid")
//	private List<AcademicRecordId> academicRecordId;

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

	public int getDurationYear() {
		return durationYear;
	}

	public void setDurationYear(int durationYear) {
		this.durationYear = durationYear;
	}

//	public List<Institutes> getInst() {
//		return inst;
//	}
//
//	public void setInst(List<Institutes> inst) {
//		this.inst = inst;
//	}

//	public List<AcademicRecordId> getAcademicRecordId() {
//		return academicRecordId;
//	}
//
//	public void setAcademicRecordId(List<AcademicRecordId> academicRecordId) {
//		this.academicRecordId = academicRecordId;
//	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", medium=" + medium + ", durationYear="
				+ durationYear + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, durationYear, medium);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseId, other.courseId)
				&& Objects.equals(courseName, other.courseName) && durationYear == other.durationYear
				&& Objects.equals(medium, other.medium);
	}

	
	
}
