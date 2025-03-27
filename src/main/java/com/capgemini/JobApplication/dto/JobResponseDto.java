package com.capgemini.JobApplication.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.capgemini.JobApplication.entity.enums.JobStatus;
import com.capgemini.JobApplication.entity.enums.JobType;

public class JobResponseDto {
	private Long id;
    private UserResponseDto employer;
    private String title;
    private String description;
    private String requirements;
    private JobType jobType;
    private String location;
    private BigDecimal salaryMin;
    private BigDecimal salaryMax;
    private List<String> skills;
    private String experienceRequired;
    private String educationRequired;
    private LocalDateTime postedDate;
    private LocalDate closingDate;
    private JobStatus jobStatus;
    private Integer views;
	public JobResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobResponseDto(Long id, UserResponseDto employer, String title, String description, String requirements,
			JobType jobType, String location, BigDecimal salaryMin, BigDecimal salaryMax, List<String> skills,
			String experienceRequired, String educationRequired, LocalDateTime postedDate, LocalDate closingDate,
			JobStatus jobStatus, Integer views) {
		super();
		this.id = id;
		this.employer = employer;
		this.title = title;
		this.description = description;
		this.requirements = requirements;
		this.jobType = jobType;
		this.location = location;
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
		this.skills = skills;
		this.experienceRequired = experienceRequired;
		this.educationRequired = educationRequired;
		this.postedDate = postedDate;
		this.closingDate = closingDate;
		this.jobStatus = jobStatus;
		this.views = views;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserResponseDto getEmployer() {
		return employer;
	}
	public void setEmployer(UserResponseDto employer) {
		this.employer = employer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public BigDecimal getSalaryMin() {
		return salaryMin;
	}
	public void setSalaryMin(BigDecimal salaryMin) {
		this.salaryMin = salaryMin;
	}
	public BigDecimal getSalaryMax() {
		return salaryMax;
	}
	public void setSalaryMax(BigDecimal salaryMax) {
		this.salaryMax = salaryMax;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getExperienceRequired() {
		return experienceRequired;
	}
	public void setExperienceRequired(String experienceRequired) {
		this.experienceRequired = experienceRequired;
	}
	public String getEducationRequired() {
		return educationRequired;
	}
	public void setEducationRequired(String educationRequired) {
		this.educationRequired = educationRequired;
	}
	public LocalDateTime getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDateTime postedDate) {
		this.postedDate = postedDate;
	}
	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}
	public JobStatus getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	
    
}
