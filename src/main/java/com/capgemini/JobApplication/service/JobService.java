package com.capgemini.JobApplication.service;

import java.util.List;

import com.capgemini.JobApplication.dto.JobCreateDto;
import com.capgemini.JobApplication.dto.JobResponseDto;
import com.capgemini.JobApplication.dto.JobUpdateDto;


public interface JobService {
List<JobResponseDto> getAllJobs();
	
	JobResponseDto getJobById (Long id);
	
	List<JobResponseDto> getJobByEmployerId(Long id);
	
	JobResponseDto addJob(JobCreateDto job);
	
	JobResponseDto updateJob(Long id, JobUpdateDto jobDto);
	
	List<JobResponseDto> getJobByTitle(String title);
	
	List<JobResponseDto> getJobByEmployerEmail(String email);
	
	void deleteJob(Long id);
}
