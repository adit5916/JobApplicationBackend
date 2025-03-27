package com.capgemini.JobApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.JobApplication.dto.JobCreateDto;
import com.capgemini.JobApplication.dto.JobResponseDto;
import com.capgemini.JobApplication.dto.JobUpdateDto;
import com.capgemini.JobApplication.entity.JobEntity;
import com.capgemini.JobApplication.exception.ResourceNotFoundException;
import com.capgemini.JobApplication.mapper.JobMapper;
import com.capgemini.JobApplication.repository.JobRepository;
import com.capgemini.JobApplication.service.JobService;


@Service
public class JobServiceImpl implements JobService{
	
	private  JobRepository jobRepository;
	private JobMapper jobMapper;

	public JobServiceImpl(JobRepository jobRepository, JobMapper jobMapper) {
		super();
		this.jobRepository = jobRepository;
		this.jobMapper = jobMapper;
	}

	@Override
	public List<JobResponseDto> getAllJobs() {
		// TODO Auto-generated method stub
		List<JobEntity> users = jobRepository.findAll();
		return jobMapper.toJobDTOList(users);
		
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
        JobEntity newJob = jobMapper.toEntity(job);
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
	
	

	}
