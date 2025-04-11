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
	        dto.setJob_type(entity.getJobType());
	        dto.setLocation(entity.getLocation());
	        dto.setSalary_min(entity.getSalaryMin());
	        dto.setSalary_max(entity.getSalaryMax());
	        dto.setSkills(entity.getSkills());
	        dto.setExperience_required(entity.getExperienceRequired());
	        dto.setEducation_required(entity.getEducationRequired());
	        dto.setPosted_date(entity.getPostedDate());
	        dto.setClosing_date(entity.getClosingDate());
	        dto.setJob_status(entity.getJobStatus());
	        
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
	        entity.setJobType(dto.getJob_type());
	        entity.setLocation(dto.getLocation());
	        entity.setSalaryMin(dto.getSalary_min());
	        entity.setSalaryMax(dto.getSalary_max());
	        entity.setSkills(dto.getSkills());
	        entity.setExperienceRequired(dto.getExperience_required());
	        entity.setEducationRequired(dto.getEducation_required());
	        entity.setClosingDate(dto.getClosing_date());
	        
	        entity.setPostedDate(LocalDateTime.now());
	        entity.setJobStatus(JobStatus.open);
	        
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
		    if (dto.getJob_type() != null) {
		        entity.setJobType(dto.getJob_type());
		    }
		    if (dto.getLocation() != null) {
		        entity.setLocation(dto.getLocation());
		    }
		    if (dto.getSalary_min() != null) {
		        entity.setSalaryMin(dto.getSalary_min());
		    }
		    if (dto.getSalary_max() != null) {
		        entity.setSalaryMax(dto.getSalary_max());
		    }

		    if (dto.getSkills() != null) {
		        entity.setSkills(dto.getSkills());
		    }

		    if (dto.getExperience_required() != null) {
		        entity.setExperienceRequired(dto.getExperience_required());
		    }

		    if (dto.getEducation_required() != null) {
		        entity.setEducationRequired(dto.getEducation_required());
		    }

		    if (dto.getClosing_date() != null) {
		        entity.setClosingDate(dto.getClosing_date());
		    }

		    if (dto.getJob_status() != null) {
		        entity.setJobStatus(dto.getJob_status());
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
