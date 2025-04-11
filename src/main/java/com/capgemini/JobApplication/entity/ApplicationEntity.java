package com.capgemini.JobApplication.entity;

import java.time.LocalDateTime;

import com.capgemini.JobApplication.entity.enums.ApplicationStatus;
import com.capgemini.JobApplication.entity.enums.UserRole;

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
@Table(name = "applications")
public class ApplicationEntity {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "job_id", referencedColumnName = "id",updatable = false)
	    private JobEntity job;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
	    private UserEntity user;
	    
	    @Column(name = "apply_date", nullable = false)
	    private LocalDateTime apply_date;
	    
	    @Enumerated(EnumType.STRING)
		@Column(name = "application_status", nullable = false, columnDefinition = "ENUM('pending', 'accepted','rejected') DEFAULT 'pending'")
		private ApplicationStatus application_status = ApplicationStatus.pending;

		public ApplicationEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ApplicationEntity(Long id, JobEntity job, UserEntity user, LocalDateTime apply_date,
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

		public JobEntity getJob() {
			return job;
		}

		public void setJob(JobEntity job) {
			this.job = job;
		}

		public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
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
