package com.capgemini.JobApplication.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.capgemini.JobApplication.dto.UserCreateDto;
import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.dto.UserUpdateDto;
import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.entity.enums.UserRole;
import com.capgemini.JobApplication.entity.enums.UserStatus;


@Component
public class UserMapper {
    
    
    
    public UserResponseDto toUserResponseDTO(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirst_name());
        dto.setLastName(entity.getLast_name());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getNumber());
        dto.setUserRole(entity.getUser_role());
        dto.setUserStatus(entity.getUser_status());
        dto.setDateCreated(entity.getDateCreated());
        
        return dto;
    }
    
    
    public UserEntity toEntity(UserCreateDto dto) {
        if (dto == null) {
            return null;
        }
        
        UserEntity entity = new UserEntity();
        entity.setFirst_name(dto.getFirstName());
        entity.setLast_name(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setNumber(dto.getPhone());
        entity.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        
        // Set default or provided role
        if (dto.getUserRole() != null) {
            entity.setUser_role(dto.getUserRole());
        } else {
            entity.setUser_role(UserRole.jobseeker);
        }
        
        // Set default status and timestamps
        entity.setUser_status(UserStatus.active);
        entity.setDateCreated(LocalDate.now());
        entity.setLastLogin(LocalDate.now());
        
        return entity;
    }
    
    
    public UserEntity updateEntityFromDTO(UserUpdateDto dto, UserEntity entity) {
        
        
        if (dto.getFirstName() != null) {
            entity.setFirst_name(dto.getFirstName());
        }
        
        if (dto.getLastName() != null) {
            entity.setLast_name(dto.getLastName());
        }
        
        if (dto.getPhone() != null) {
            entity.setNumber(dto.getPhone());
        }
        
        if (dto.getEmail() != null) {
            entity.setEmail(null);
        }
        
        if (dto.getUserStatus() != null) {
            entity.setUser_status(dto.getUserStatus());
        }
        return entity;
    }
    
    
    public UserEntity updatePassword(UserEntity entity, String newPassword) {
        entity.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        return entity;
    }
    
   
    
    
    
    public List<UserResponseDto> toUserResponseDTOList(List<UserEntity> entities) {
        if (entities == null) {
            return null;
        }
        
        List<UserResponseDto> dtoList = new ArrayList<>(entities.size());
        for (UserEntity entity : entities) {
            dtoList.add(toUserResponseDTO(entity));
        }
        
        return dtoList;
    }
}
