package com.capgemini.JobApplication.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.capgemini.JobApplication.entity.enums.JobStatus;
import com.capgemini.JobApplication.entity.enums.JobType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobEntity {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "employer_id", referencedColumnName = "id", updatable = false)
	    private UserEntity employer;
	    
	    @Column(name = "title", nullable = false, length = 225)
	    private String title;
	    
	    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
	    private String description;
	    
	    @Column(name = "requirements", nullable = false, columnDefinition = "TEXT")
	    private String requirements;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name = "job_type", nullable = false)
	    private JobType jobType;
	    
	    @Column(name = "location", nullable = false, length = 225)
	    private String location;
	    
	    @Column(name = "salary_min", precision = 10, scale = 2)
	    private BigDecimal salaryMin;
	    
	    @Column(name = "salary_max", precision = 10, scale = 2)
	    private BigDecimal salaryMax;
	    
	    @Column(name = "skills", columnDefinition = "json")
	    @JdbcTypeCode(SqlTypes.JSON)
	    private List<String> skills;
	    
	    @Column(name = "experience_required", length = 255)
	    private String experienceRequired;
	    
	    @Column(name = "education_required", length = 255)
	    private String educationRequired;
	    
	    @Column(name = "posted_date", nullable = false)
	    private LocalDateTime postedDate;
	    
	    @Column(name = "closing_date")
	    private LocalDate closingDate;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name = "job_status", nullable = false)
	    private JobStatus jobStatus = JobStatus.open;

		public JobEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public JobEntity(Long id, UserEntity employer, String title, String description,
				String requirements, JobType jobType, String location, BigDecimal salaryMin, BigDecimal salaryMax,
				List<String> skills, String experienceRequired, String educationRequired, LocalDateTime postedDate,
				LocalDate closingDate, JobStatus jobStatus) {
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
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public UserEntity getEmployer() {
			return employer;
		}

		public void setEmployer(UserEntity employer) {
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
	    
	    
	    
}
