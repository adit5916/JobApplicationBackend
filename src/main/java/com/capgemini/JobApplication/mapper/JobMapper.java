package com.capgemini.JobApplication.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.JobApplication.dto.JobCreateDto;
import com.capgemini.JobApplication.dto.JobResponseDto;
import com.capgemini.JobApplication.dto.JobUpdateDto;
import com.capgemini.JobApplication.entity.JobEntity;
import com.capgemini.JobApplication.entity.enums.JobStatus;

@Component
public class JobMapper {
	
	private UserMapper userMapper;

	public JobMapper(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	
	 public JobResponseDto toJobDTO(JobEntity entity) {
	        if (entity == null) {
	            return null;
	        }
	        
	        JobResponseDto dto = new JobResponseDto();
	        dto.setId(entity.getId());
	        
	        // Set employer details using UserMapper
	        if (entity.getEmployer() != null) {
	            dto.setEmployer(userMapper.toUserResponseDTO(entity.getEmployer()));
	        }
	        
	        dto.setTitle(entity.getTitle());
	        dto.setDescription(entity.getDescription());
	        dto.setRequirements(entity.getRequirements());
	        dto.setJobType(entity.getJobType());
	        dto.setLocation(entity.getLocation());
	        dto.setSalaryMin(entity.getSalaryMin());
	        dto.setSalaryMax(entity.getSalaryMax());
	        dto.setSkills(entity.getSkills());
	        dto.setExperienceRequired(entity.getExperienceRequired());
	        dto.setEducationRequired(entity.getEducationRequired());
	        dto.setPostedDate(entity.getPostedDate());
	        dto.setClosingDate(entity.getClosingDate());
	        dto.setJobStatus(entity.getJobStatus());
	        dto.setViews(entity.getViews());
	        
	        return dto;
	    }
	 
	 public JobEntity toEntity(JobCreateDto dto) {
	        if (dto == null) {
	            return null;
	        }
	        
	        JobEntity entity = new JobEntity();
	        entity.setTitle(dto.getTitle());
	        entity.setDescription(dto.getDescription());
	        entity.setRequirements(dto.getRequirements());
	        entity.setJobType(dto.getJobType());
	        entity.setLocation(dto.getLocation());
	        entity.setSalaryMin(dto.getSalaryMin());
	        entity.setSalaryMax(dto.getSalaryMax());
	        entity.setSkills(dto.getSkills());
	        entity.setExperienceRequired(dto.getExperienceRequired());
	        entity.setEducationRequired(dto.getEducationRequired());
	        entity.setClosingDate(dto.getClosingDate());
	        
	        entity.setPostedDate(LocalDateTime.now());
	        entity.setJobStatus(JobStatus.open);
	        entity.setViews(0);
	        
	        return entity;
	    }
	 
	 public JobEntity updateEntityFromDTO(JobUpdateDto dto, JobEntity entity) {
		    
		    if (dto.getTitle() != null) {
		        entity.setTitle(dto.getTitle());
		    }
		    if (dto.getDescription() != null) {
		    	
		        entity.setDescription(dto.getDescription());
		    }

		    if (dto.getRequirements() != null) {
		        entity.setRequirements(dto.getRequirements());
		    }
		    if (dto.getJobType() != null) {
		        entity.setJobType(dto.getJobType());
		    }
		    if (dto.getLocation() != null) {
		        entity.setLocation(dto.getLocation());
		    }
		    if (dto.getSalaryMin() != null) {
		        entity.setSalaryMin(dto.getSalaryMin());
		    }
		    if (dto.getSalaryMax() != null) {
		        entity.setSalaryMax(dto.getSalaryMax());
		    }

		    if (dto.getSkills() != null) {
		        entity.setSkills(dto.getSkills());
		    }

		    if (dto.getExperienceRequired() != null) {
		        entity.setExperienceRequired(dto.getExperienceRequired());
		    }

		    if (dto.getEducationRequired() != null) {
		        entity.setEducationRequired(dto.getEducationRequired());
		    }

		    if (dto.getClosingDate() != null) {
		        entity.setClosingDate(dto.getClosingDate());
		    }

		    if (dto.getJobStatus() != null) {
		        entity.setJobStatus(dto.getJobStatus());
		    }
		    return entity;
		}
	 public List<JobResponseDto> toJobDTOList(List<JobEntity> entities) {
	        if (entities == null) {
	            return null;
	        }
	        
	        return entities.stream()
	            .map(this::toJobDTO)
	            .collect(Collectors.toList());
	    }
}
