package com.capgemini.JobApplication.dto;

import java.time.LocalDateTime;

import com.capgemini.JobApplication.entity.enums.ApplicationStatus;

public class ApplicationResponseDto {
	private Long id;
    private JobResponseDto job;
    private UserResponseDto user;
    private LocalDateTime apply_date;
    private ApplicationStatus application_status;
	public ApplicationResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicationResponseDto(Long id, JobResponseDto job, UserResponseDto user, LocalDateTime apply_date,
			ApplicationStatus application_status) {
		super();
		this.id = id;
		this.job = job;
		this.user = user;
		this.apply_date = apply_date;
		this.application_status = application_status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public JobResponseDto getJob() {
		return job;
	}
	public void setJob(JobResponseDto job) {
		this.job = job;
	}
	public UserResponseDto getUser() {
		return user;
	}
	public void setUser(UserResponseDto user) {
		this.user = user;
	}
	public LocalDateTime getApply_date() {
		return apply_date;
	}
	public void setApply_date(LocalDateTime apply_date) {
		this.apply_date = apply_date;
	}
	public ApplicationStatus getApplication_status() {
		return application_status;
	}
	public void setApplication_status(ApplicationStatus application_status) {
		this.application_status = application_status;
	}
	
}
