package com.app.entities;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;



@Entity
@Table(name="studentPersonalInfo")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false,doNotUseGetters = true,of="email")


public class StudentPersonalInfo {
	
	@Id
	@Column(name="uid", insertable=true, updatable=true, unique=true, nullable=false)
	private Long uid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30)
	private String middleName;
	
	@Column(length = 30)
	private String lastName;
	
	@Column(length = 30)
	private String fatherName;
	
	@Column(length = 30)
	private String motherName;
	
	@Column(length = 30, unique = true) // =>unique
	private String email;
	
	@Column(length = 30)
	private String gender;
	
	@Column(length = 30)
	private String categorytype;
	
	@Column(length = 30)
	private String religion;
	
	@Column(length = 100)
	private String address;
	
	@Column(length=20)
	private String city;
	
	@Column(length=20)
	private String state;
	
	@Column(length=20)
	private String country;
	
	@Column(length=20,name="zip_code")
	private String zipCode;
	
	@Column(nullable = false) // =>NOT NULL
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(length = 10)
	private String contact;
	
//	@OneToMany(mappedBy = "studentPersonalInfo",
//			cascade = CascadeType.ALL)
//	private List<StudentAcademicDetails> studentAcademicDetails;
	
	

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "StudentPersonalInfo [uid=" + uid + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", fatherName=" + fatherName + ", motherName=" + motherName + ", email="
				+ email + ", gender=" + gender + ", categorytype=" + categorytype + ", religion=" + religion
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + ", password=" + password + ", dob=" + dob + ", contact=" + contact + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

//	public List<StudentAcademicDetails> getStudentAcademicDetails() {
//		return studentAcademicDetails;
//	}
//
//	public void setStudentAcademicDetails(List<StudentAcademicDetails> studentAcademicDetails) {
//		this.studentAcademicDetails = studentAcademicDetails;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(address, categorytype, city, contact, country, dob, email, fatherName, firstName, gender,
				lastName, middleName, motherName, password, religion, state, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPersonalInfo other = (StudentPersonalInfo) obj;
		return Objects.equals(address, other.address) && categorytype == other.categorytype
				&& Objects.equals(city, other.city) && Objects.equals(contact, other.contact)
				&& Objects.equals(country, other.country) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && Objects.equals(fatherName, other.fatherName)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(motherName, other.motherName) && Objects.equals(password, other.password)
				&& Objects.equals(religion, other.religion) && Objects.equals(state, other.state)
				&& Objects.equals(zipCode, other.zipCode);
	}

	
	
	
	
	
//	public StudentPersonalInfo(String firstName, String middleName, String lastName, String fatherName,
//			String motherName, String email, String gender, CategoryType categorytype, String religion, String address,
//			String city, String state, String country, String zipCode, String password, LocalDate dob, String contact) {
//		super();
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.fatherName = fatherName;
//		this.motherName = motherName;
//		this.email = email;
//		this.gender = gender;
//		this.categorytype = categorytype;
//		this.religion = religion;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.zipCode = zipCode;
//		this.password = password;
//		this.dob = dob;
//		this.contact = contact;
//	}
	
	

	
	
	
	// many to one association
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)//MERGE : NEW n INTERESTING !!!!!
//	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
//	private Department dept;
//	// many-to many : non owning
//	@ManyToMany(mappedBy = "emps")
//	//want to change collection type to List : in inverse side : TO DO
//	private List<Project> projects = new ArrayList<>();
//	
}
