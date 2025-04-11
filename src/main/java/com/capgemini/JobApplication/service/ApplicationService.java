package com.capgemini.JobApplication.service;

import java.util.List;
import com.capgemini.JobApplication.dto.ApplicationResponseDto;
import com.capgemini.JobApplication.entity.enums.ApplicationStatus;


public interface ApplicationService {
List<ApplicationResponseDto> getAllApplications();
	
ApplicationResponseDto getApplicationById (Long id);


ApplicationResponseDto updateApplication(Long id, ApplicationStatus status);
	
ApplicationResponseDto addApplication(Long jobId);

List<ApplicationResponseDto> getApplicationsByJobId(Long jobId);
List<ApplicationResponseDto> getApplicationsByEmployerId(Long employerId);
List<ApplicationResponseDto> getApplicationsByUserId(Long userId);
	
}
