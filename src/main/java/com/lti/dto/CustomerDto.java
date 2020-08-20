package com.lti.dto;

import java.time.LocalDate;
import org.springframework.web.multipart.MultipartFile;

public class CustomerDto {

	private String name;
	private LocalDate dateOfBirth;
	private String email;
	private String password;

	private MultipartFile profilePicPath;

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

	public MultipartFile getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(MultipartFile profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
}
