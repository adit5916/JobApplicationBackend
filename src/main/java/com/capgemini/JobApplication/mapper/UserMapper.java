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
import com.capgemini.JobApplication.entity.enums.UserStatus;


@Component
public class UserMapper {
    
    
    
    public UserResponseDto toUserResponseDTO(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setFirst_name(entity.getFirst_name());
        dto.setLast_name(entity.getLast_name());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getNumber());
        dto.setUser_role(entity.getUser_role());
        dto.setUser_status(entity.getUser_status());
        dto.setDate_created(entity.getDateCreated());
        
        return dto;
    }
    
    
    public UserEntity toEntity(UserCreateDto dto) {
        if (dto == null) {
            return null;
        }
        
        UserEntity entity = new UserEntity();
        entity.setFirst_name(dto.getFirst_name());
        entity.setLast_name(dto.getLast_name());
        entity.setEmail(dto.getEmail());
        entity.setNumber(dto.getPhone());
        entity.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        entity.setUser_role(dto.getUser_role());
        // Set default status and timestamps
        entity.setUser_status(UserStatus.active);
        entity.setDateCreated(LocalDate.now());
        
        return entity;
    }
    
    
    public UserEntity updateEntityFromDTO(UserUpdateDto dto, UserEntity entity) {
        
        
        if (dto.getFirst_name() != null) {
            entity.setFirst_name(dto.getFirst_name());
        }
        
        if (dto.getLast_name() != null) {
            entity.setLast_name(dto.getLast_name());
        }
        
        if (dto.getPhone() != null) {
            entity.setNumber(dto.getPhone());
        }
        
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        
        if (dto.getUser_status() != null) {
            entity.setUser_status(dto.getUser_status());
        }
        if (dto.getUser_role() != null) {
            entity.setUser_role(dto.getUser_role());
        }
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
