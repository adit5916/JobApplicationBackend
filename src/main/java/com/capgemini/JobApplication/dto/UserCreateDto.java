package com.capgemini.JobApplication.dto;

import com.capgemini.JobApplication.entity.enums.UserRole;

public class UserCreateDto {
	private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private UserRole userRole;
	public UserCreateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCreateDto(String firstName, String lastName, String email, String phone, String password,
			UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.userRole = userRole;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
    
    
}
