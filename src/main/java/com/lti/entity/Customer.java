package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SB_CUST")
@NamedQuery(name = "fetch-all", query = "select c from Customer c")
@NamedQuery(name = "fetch-login", query = ("select c.id from Customer c where c.email = :email and c.password = :password"))
public class Customer {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private LocalDate dateOfBirth;

	@Column(name = "email", unique = true)
	private String email;
	private String password;

	private String profilePicPath;

	public Customer() {
		super();
	}

	public Customer(int id, String name, LocalDate dateOfBirth, String email, String password,String profilePicPath) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.profilePicPath = profilePicPath;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

}
