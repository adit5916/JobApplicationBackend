package com.capgemini.JobApplication.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.JobApplication.entity.enums.JobStatus;
import com.capgemini.JobApplication.entity.enums.JobType;

public class JobUpdateDto {
	 private String title;
	    private String description;
	    private String requirements;
	    private JobType job_type;
	    private String location;
	    private BigDecimal salary_min;
	    private BigDecimal salary_max;
	    private List<String> skills;
	    private String experience_required;
	    private String education_required;
	    private LocalDate closing_date;
	    private JobStatus job_status;
		public JobUpdateDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public JobUpdateDto(String title, String description, String requirements, JobType job_type, String location,
				BigDecimal salary_min, BigDecimal salary_max, List<String> skills, String experience_required,
				String education_required, LocalDate closing_date, JobStatus job_status) {
			super();
			this.title = title;
			this.description = description;
			this.requirements = requirements;
			this.job_type = job_type;
			this.location = location;
			this.salary_min = salary_min;
			this.salary_max = salary_max;
			this.skills = skills;
			this.experience_required = experience_required;
			this.education_required = education_required;
			this.closing_date = closing_date;
			this.job_status = job_status;
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
		public JobType getJob_type() {
			return job_type;
		}
		public void setJob_type(JobType job_type) {
			this.job_type = job_type;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public BigDecimal getSalary_min() {
			return salary_min;
		}
		public void setSalary_min(BigDecimal salary_min) {
			this.salary_min = salary_min;
		}
		public BigDecimal getSalary_max() {
			return salary_max;
		}
		public void setSalary_max(BigDecimal salary_max) {
			this.salary_max = salary_max;
		}
		public List<String> getSkills() {
			return skills;
		}
		public void setSkills(List<String> skills) {
			this.skills = skills;
		}
		public String getExperience_required() {
			return experience_required;
		}
		public void setExperience_required(String experience_required) {
			this.experience_required = experience_required;
		}
		public String getEducation_required() {
			return education_required;
		}
		public void setEducation_required(String education_required) {
			this.education_required = education_required;
		}
		public LocalDate getClosing_date() {
			return closing_date;
		}
		public void setClosing_date(LocalDate closing_date) {
			this.closing_date = closing_date;
		}
		public JobStatus getJob_status() {
			return job_status;
		}
		public void setJob_status(JobStatus job_status) {
			this.job_status = job_status;
		}
		
		}
