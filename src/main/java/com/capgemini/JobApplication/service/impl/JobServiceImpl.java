package com.capgemini.JobApplication.service.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.capgemini.JobApplication.dto.JobCreateDto;
import com.capgemini.JobApplication.dto.JobResponseDto;
import com.capgemini.JobApplication.dto.JobUpdateDto;
import com.capgemini.JobApplication.entity.JobEntity;
import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.exception.ResourceNotFoundException;
import com.capgemini.JobApplication.mapper.JobMapper;
import com.capgemini.JobApplication.repository.JobRepository;
import com.capgemini.JobApplication.repository.UserRepository;
import com.capgemini.JobApplication.service.JobService;


@Service
public class JobServiceImpl implements JobService{
	
	private  JobRepository jobRepository;
	private JobMapper jobMapper;
	private UserRepository userRepository;

	public JobServiceImpl(JobRepository jobRepository, JobMapper jobMapper, UserRepository userRepository) {
		super();
		this.jobRepository = jobRepository;
		this.jobMapper = jobMapper;
		this.userRepository = userRepository;
	}

	@Override
	public List<JobResponseDto> getAllJobs() {
		// TODO Auto-generated method stub
		List<JobEntity> jobs = jobRepository.findAll();
		return jobMapper.toJobDTOList(jobs);
		
	}

	@Override
	public JobResponseDto getJobById(Long id) {
		// TODO Auto-generated method stub
		JobEntity job = jobRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
		return jobMapper.toJobDTO(job);	
	}

	@Override
	public JobResponseDto addJob(JobCreateDto job) {
		// TODO Auto-generated method stub
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String email = authentication.getName();
	        
	        UserEntity employer = userRepository.findByEmail(email)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        JobEntity newJob = jobMapper.toEntity(job);
        newJob.setEmployer(employer);
        JobEntity savedJob = jobRepository.save(newJob);
        return jobMapper.toJobDTO(savedJob);
	}

	@Override
	public JobResponseDto updateJob(Long id, JobUpdateDto jobDto) {
		// TODO Auto-generated method stub
		JobEntity existingJob = jobRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
	        
	        
	        
	        JobEntity updatedUser = jobMapper.updateEntityFromDTO(jobDto, existingJob);
	        JobEntity savedUser = jobRepository.save(updatedUser);
	        return jobMapper.toJobDTO(savedUser);
	}

	@Override
	public void deleteJob(Long id) {
		// TODO Auto-generated method stub
		if (!jobRepository.existsById(id)) {
            throw new ResourceNotFoundException("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }

	@Override
	public List<JobResponseDto> getJobByEmployerId(Long id) {
		userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		
		List<JobEntity> jobs = jobRepository.findByEmployerId(id);
	            
		return jobMapper.toJobDTOList(jobs);	
	}

	@Override
	public List<JobResponseDto> getJobByTitle(String title) {
		List<JobEntity> job = jobRepository.findByTitle(title);
	        return jobMapper.toJobDTOList(job);
	}

	@Override
	public List<JobResponseDto> getJobByEmployerEmail(String email) {
		List<JobEntity> job = jobRepository.findByEmployerEmail(email);
		        return jobMapper.toJobDTOList(job);
	}
	
	

	}
