package com.app.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


public class StudentRespDTO {
	@JsonProperty(access = Access.READ_ONLY)
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
	@NotBlank
	private String email;
	@NotBlank
	private String gender;
	@NotBlank
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
	@NotBlank
	private LocalDate dob;
	@NotBlank
	private String contact;
	@NotBlank
	private String pwdStatus;

	
	@Override
	public String toString() {
		return "StudentRespDTO [uid=" + uid + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", fatherName=" + fatherName + ", motherName=" + motherName + ", email=" + email
				+ ", gender=" + gender + ", categorytype=" + categorytype + ", religion=" + religion + ", address="
				+ address + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode
				+ ", dob=" + dob + ", contact=" + contact + ", pwdStatus=" + pwdStatus + "]";
	}

	
	public String getPwdStatus() {
		return pwdStatus;
	}

	public void setPwdStatus(String pwdStatus) {
		this.pwdStatus = pwdStatus;
	}

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
	

}
