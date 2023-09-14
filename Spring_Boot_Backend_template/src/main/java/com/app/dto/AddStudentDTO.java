package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;


public class AddStudentDTO {
	//@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long uid;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String middleName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String fatherName;
	
	@NotBlank
	private String motherName;
	
	@Email
	private String email;
	private String password;
	private String gender;
	
	
	private String categorytype;
	
	@NotBlank
	private String religion;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String zipCode;
	
	
	
	private LocalDate dob;
	
	@NotBlank
	private String contact;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "AddStudentDTO [uid=" + uid + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", fatherName=" + fatherName + ", motherName=" + motherName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", categorytype=" + categorytype + ", religion="
				+ religion + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipCode=" + zipCode + ", dob=" + dob + ", contact=" + contact + "]";
	}

}
