package com.capgemini.JobApplication.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.capgemini.JobApplication.dto.ApplicationResponseDto;
import com.capgemini.JobApplication.entity.ApplicationEntity;
import com.capgemini.JobApplication.entity.JobEntity;
import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.entity.enums.ApplicationStatus;
import com.capgemini.JobApplication.exception.ResourceNotFoundException;
import com.capgemini.JobApplication.mapper.ApplicationMapper;
import com.capgemini.JobApplication.repository.ApplicationRepository;
import com.capgemini.JobApplication.repository.JobRepository;
import com.capgemini.JobApplication.repository.UserRepository;
import com.capgemini.JobApplication.service.ApplicationService;


@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	private ApplicationRepository applicationRepository;
	private ApplicationMapper applicationMapper;
	private UserRepository userRepository;
	private JobRepository jobRepository;
	
	
	

	public ApplicationServiceImpl(ApplicationRepository applicationRepository, ApplicationMapper applicationMapper, UserRepository userRepository, JobRepository jobRepository) {
		super();
		this.applicationRepository = applicationRepository;
		this.applicationMapper = applicationMapper;
		this.userRepository=userRepository;
		this.jobRepository= jobRepository;
	}

	@Override
	public List<ApplicationResponseDto> getAllApplications() {
		// TODO Auto-generated method stub
		List<ApplicationEntity> applications = applicationRepository.findAll();
		return applicationMapper.toApplicationDTOList(applications);
	}

	@Override
	public ApplicationResponseDto getApplicationById(Long id) {
		// TODO Auto-generated method stub
		ApplicationEntity applications = applicationRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
		return applicationMapper.toApplicationDTO(applications);	
	}

	@Override
	public ApplicationResponseDto addApplication(Long jobId) {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
		ApplicationEntity newApplication = new ApplicationEntity();
		newApplication.setApply_date(LocalDateTime.now());
		newApplication.setUser(user);
		newApplication.setApplication_status(ApplicationStatus.pending);
		
		JobEntity job = jobRepository.findById(jobId).
				orElseThrow(() -> new ResourceNotFoundException("Job not found"));
		newApplication.setJob(job);
		
        ApplicationEntity savedApplication = applicationRepository.save(newApplication);
        return applicationMapper.toApplicationDTO(savedApplication);
	}

	@Override
	public List<ApplicationResponseDto> getApplicationsByJobId(Long jobId) {
		if (!jobRepository.existsById(jobId)) {
	        throw new ResourceNotFoundException("Application not found with job id: " + jobId);
	    }
		List<ApplicationEntity> applications = applicationRepository.findByJobId(jobId);
		return applicationMapper.toApplicationDTOList(applications);
	}

	@Override
	public List<ApplicationResponseDto> getApplicationsByEmployerId(Long employerId) {
		if (!userRepository.existsById(employerId)) {
	        throw new ResourceNotFoundException("Application not found with employer id: " + employerId);
	    }
		List<ApplicationEntity> applications = applicationRepository.findByEmployerId(employerId);
		return applicationMapper.toApplicationDTOList(applications);
	}

	@Override
	public List<ApplicationResponseDto> getApplicationsByUserId(Long userId) {
		if (!userRepository.existsById(userId)) {
	        throw new ResourceNotFoundException("Application not found with user id: " + userId);
	    }
		List<ApplicationEntity> applications = applicationRepository.findByUserId(userId);
		return applicationMapper.toApplicationDTOList(applications);
	}
	
	@Override
	public ApplicationResponseDto updateApplication(Long id, ApplicationStatus status) {
		ApplicationEntity existingApplication = applicationRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
	        
	        
	        
//		ApplicationEntity updatedApplication = applicationMapper.updateEntityFromDto(applicationDto, existingApplication);
		existingApplication.setApplication_status(status);
		ApplicationEntity savedApplication = applicationRepository.save(existingApplication);
	        return applicationMapper.toApplicationDTO(savedApplication);
	}

}
