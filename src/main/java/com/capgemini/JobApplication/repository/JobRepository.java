package com.capgemini.JobApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.JobApplication.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long>{
	
	List<JobEntity> findByEmployerId(Long employerId);
	
	List<JobEntity> findByTitle(String title);
		
	@Query("SELECT j FROM JobEntity j WHERE j.employer.email = :email")
	List<JobEntity> findByEmployerEmail(@Param("email") String email);
}
