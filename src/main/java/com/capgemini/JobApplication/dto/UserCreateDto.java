package com.capgemini.JobApplication.dto;

import com.capgemini.JobApplication.entity.enums.UserRole;

public class UserCreateDto {
	private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String password;
    private UserRole user_role;
	public UserCreateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCreateDto(String first_name, String last_name, String email, String phone, String password,
			UserRole user_role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.user_role = user_role;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	public UserRole getUser_role() {
		return user_role;
	}
	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}
	    
}
