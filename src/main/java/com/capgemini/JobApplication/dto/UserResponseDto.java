package com.capgemini.JobApplication.dto;

import java.time.LocalDate;

import com.capgemini.JobApplication.entity.enums.UserRole;
import com.capgemini.JobApplication.entity.enums.UserStatus;

public class UserResponseDto {
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole userRole;
    private UserStatus userStatus;
    private LocalDate dateCreated;
	public UserResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDto(Long id, String firstName, String lastName, String email, String phone, UserRole userRole,
			UserStatus userStatus, LocalDate dateCreated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.userRole = userRole;
		this.userStatus = userStatus;
		this.dateCreated = dateCreated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
    
    
}
