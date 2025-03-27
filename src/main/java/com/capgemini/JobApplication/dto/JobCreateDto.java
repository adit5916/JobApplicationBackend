package com.capgemini.JobApplication.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.JobApplication.entity.enums.JobType;

public class JobCreateDto {
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
    private LocalDate closingDate;
	public JobCreateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobCreateDto(String title, String description, String requirements, JobType jobType, String location,
			BigDecimal salaryMin, BigDecimal salaryMax, List<String> skills, String experienceRequired,
			String educationRequired, LocalDate closingDate) {
		super();
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
		this.closingDate = closingDate;
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
	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}
    
    
    
}
