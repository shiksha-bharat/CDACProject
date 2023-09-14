package com.app.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "institute")

public class Institutes extends IdGenerator{

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public List<Desks> getDesk() {
		return desk;
	}
	public void setDesk(List<Desks> desk) {
		this.desk = desk;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

//	public List<AcademicRecordId> getStudentAcademicDetails() {
//		return studentAcademicDetails;
//	}
//	public void setStudentAcademicDetails(List<AcademicRecordId> studentAcademicDetails) {
//		this.studentAcademicDetails = studentAcademicDetails;
//	}


@Column(length = 50)
private String name;
@Column(length = 100)
private String address;
@Column(length = 15)
private String city;
@Column(length = 20)
private String state;
@Column(length = 6)
private int pincode;
@Column(length = 50)
private String university;
@Override
public String toString() {
	return "Institutes [id=" + super.getId() + ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state
			+ ", pincode=" + pincode + ", university=" + university + ", desk=" + desk + ", status=" + status + "]";
}
@OneToMany(mappedBy = "inst", fetch = FetchType.EAGER,
cascade = CascadeType.ALL, 
orphanRemoval = true  )
private List<Desks> desk;


//@ManyToMany(cascade = CascadeType.PERSIST) 
//private List<Course> course;


public void addDesks(Desks d) {
	desk.add(d);
	d.setInst(this);
}
public void removeEmployee(Desks d) {
	desk.remove(d);
	d.setInst(null);
}
private boolean status;



}
