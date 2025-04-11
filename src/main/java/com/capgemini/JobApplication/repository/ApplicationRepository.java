package com.capgemini.JobApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.JobApplication.entity.ApplicationEntity;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long>{
	// Find applications by job ID
    List<ApplicationEntity> findByJobId(Long jobId);
    
    // Find applications by employer ID
    @Query("SELECT a FROM ApplicationEntity a WHERE a.job.employer.id = :employerId")
    List<ApplicationEntity> findByEmployerId(@Param("employerId") Long employerId);
    
    // Find applications by user ID (the applicant)
    List<ApplicationEntity> findByUserId(Long userId);
}
