package com.capgemini.JobApplication.dto;

import java.time.LocalDateTime;

public class ApplicationResponseDto {
	private Long id;
    private JobResponseDto job;
    private UserResponseDto user;
    private LocalDateTime applyDate;
	public ApplicationResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicationResponseDto(Long id, JobResponseDto job, UserResponseDto user, LocalDateTime applyDate) {
		super();
		this.id = id;
		this.job = job;
		this.user = user;
		this.applyDate = applyDate;
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
	public LocalDateTime getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}
    
    
}
