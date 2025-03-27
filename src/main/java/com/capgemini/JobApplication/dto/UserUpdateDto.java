package com.capgemini.JobApplication.dto;

import com.capgemini.JobApplication.entity.enums.UserStatus;

public class UserUpdateDto {
	private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private UserStatus userStatus;
	public UserUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdateDto(String firstName, String lastName, String phone, String email, UserStatus userStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.userStatus = userStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
    
    
}
