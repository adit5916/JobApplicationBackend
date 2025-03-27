package com.capgemini.JobApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.JobApplication.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{
	
}
