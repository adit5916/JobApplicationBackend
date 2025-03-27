package com.capgemini.JobApplication.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.JobApplication.dto.ApplicationCreateDto;
import com.capgemini.JobApplication.dto.ApplicationResponseDto;
import com.capgemini.JobApplication.entity.ApplicationEntity;

@Component
public class ApplicationMapper {
	private UserMapper userMapper;
	private JobMapper jobMapper;
	public ApplicationMapper(UserMapper userMapper, JobMapper jobMapper) {
		super();
		this.userMapper = userMapper;
		this.jobMapper = jobMapper;
	}
	
	 public ApplicationResponseDto toApplicationDTO(ApplicationEntity entity) {
	        if (entity == null) {
	            return null;
	        }
	        
	        ApplicationResponseDto dto = new ApplicationResponseDto();
	        dto.setId(entity.getId());
	        
	        // Map job
	        if (entity.getJob() != null) {
	            dto.setJob(jobMapper.toJobDTO(entity.getJob()));
	        }
	        
	        // Map user
	        if (entity.getUser() != null) {
	            dto.setUser(userMapper.toUserResponseDTO(entity.getUser()));
	        }
	        
	        dto.setApplyDate(entity.getApplyDate());
	        
	        return dto;
	    }
	 
	 
	 public ApplicationEntity toEntity(ApplicationCreateDto dto) {
	        if (dto == null) {
	            return null;
	        }
	        
	        ApplicationEntity entity = new ApplicationEntity();
	        
	        // Note: Job and User should be set in the service layer
	        // using repositories or as method parameters
	        entity.setApplyDate(LocalDateTime.now());
	        
	        return entity;
	    }
	 
	 public List<ApplicationResponseDto> toApplicationDTOList(List<ApplicationEntity> entities) {
	        if (entities == null) {
	            return null;
	        }
	        
	        return entities.stream()
	            .map(this::toApplicationDTO)
	            .collect(Collectors.toList());
	    }
}
