package com.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user_table")
public class User {
   

	@Id
    @GeneratedValue
	private Long id;
	
	@NotNull(message = "firstname shouldn't be null")
	private String firstname;
	private String lastname;
	private String email;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date dob;
	private String gender;
	private String education;
	private String company;
	private String experience;
	private String packag;
	
	public User() {
		
	}
	public User(Long id, String firstname, String lastname, String email, Date dob, String gender, 
			String education, String company, String experience, String packag) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.education = education;
		this.company = company;
		this.experience = experience;
		this.packag = packag;
	}	
	public User(String firstname, String lastname, String email, String gender, Date dob, 
			String education, String company, String experience, String packag) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.education = education;
		this.company = company;
		this.experience = experience;
		this.packag = packag;
	}

	 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
	
}
