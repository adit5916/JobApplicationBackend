package com.capgemini.JobApplication.dto;

public class ApplicationCreateDto {
	 
	private Long jobId;
	 private Long userId;

	public ApplicationCreateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationCreateDto(Long jobId, Long userId) {
		super();
		this.jobId = jobId;
		this.userId = userId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	 
	 
}
