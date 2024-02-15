package com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.entity.User;

//@Data
//@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
public class UserRequest {
	@NotNull(message = "firstname shouldn't be null")
	private String firstname;
	private String lastname;
	
	@Email(message = "invalid email address")
	private String email;
    private Date dob;
	private String gender;
	private String education;
	private String company;
	private String experience;
	private String packag;
	private String message;
	
	public UserRequest() {
		
	}
	
	public UserRequest(User user, String message) {
		this(user.getFirstname(), user.getLastname(), user.getEmail(), user.getDob(), user.getGender(), user.getEducation(), 
				user.getCompany(), user.getExperience(), user.getPackag(), message);
	}
	
	public UserRequest(String firstname, String lastname, String email, Date date, String gender, 
			String education, String company, String experience, String packag, String message) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.education = education;
		this.company = company;
		this.experience = experience;
		this.packag = packag;
		this.message = message;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getPackag() {
		return packag;
	}
	public void setPackag(String packag) {
		this.packag = packag;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
