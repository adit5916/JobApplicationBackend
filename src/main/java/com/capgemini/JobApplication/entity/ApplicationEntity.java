package com.capgemini.JobApplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	    
	    @Column(name = "applyDate", nullable = false)
	    private LocalDateTime applyDate;

		public ApplicationEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ApplicationEntity(Long id, JobEntity job, UserEntity user,
				LocalDateTime applyDate) {
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

		public LocalDateTime getApplyDate() {
			return applyDate;
		}

		public void setApplyDate(LocalDateTime applyDate) {
			this.applyDate = applyDate;
		}
	    
	    
}
