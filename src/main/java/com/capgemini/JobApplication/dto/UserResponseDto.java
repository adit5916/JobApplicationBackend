package com.capgemini.JobApplication.dto;

import java.time.LocalDate;

import com.capgemini.JobApplication.entity.enums.UserRole;
import com.capgemini.JobApplication.entity.enums.UserStatus;

public class UserResponseDto {
	private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private UserRole user_role;
    private UserStatus user_status;
    private LocalDate date_created;
	public UserResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDto(Long id, String first_name, String last_name, String email, String phone, UserRole user_role,
			UserStatus user_status, LocalDate date_created) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.user_role = user_role;
		this.user_status = user_status;
		this.date_created = date_created;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public UserRole getUser_role() {
		return user_role;
	}
	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}
	public UserStatus getUser_status() {
		return user_status;
	}
	public void setUser_status(UserStatus user_status) {
		this.user_status = user_status;
	}
	public LocalDate getDate_created() {
		return date_created;
	}
	public void setDate_created(LocalDate date_created) {
		this.date_created = date_created;
	}
	    
}
