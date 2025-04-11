package com.capgemini.JobApplication.dto;

import com.capgemini.JobApplication.entity.enums.UserRole;
import com.capgemini.JobApplication.entity.enums.UserStatus;

public class UserUpdateDto {
	private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private UserStatus user_status;
    private UserRole user_role;
	public UserUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdateDto(String first_name, String last_name, String phone, String email, UserStatus user_status,
			UserRole user_role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.user_status = user_status;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserStatus getUser_status() {
		return user_status;
	}
	public void setUser_status(UserStatus user_status) {
		this.user_status = user_status;
	}
	public UserRole getUser_role() {
		return user_role;
	}
	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}
	
	    
}
