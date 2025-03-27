package com.capgemini.JobApplication.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.JobApplication.dto.UserCreateDto;
import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.mapper.UserMapper;
import com.capgemini.JobApplication.repository.UserRepository;
import com.capgemini.JobApplication.service.AuthService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private  UserRepository userRepository;
	private UserMapper userMapper;

	public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	@Transactional
	public UserResponseDto createUser(UserCreateDto userRequest) {
		Optional<UserEntity> existingUser = userRepository.findByEmail(userRequest.getEmail());
        if (existingUser.isPresent()) {
        	
            throw new IllegalArgumentException("Email already exists");
        }
        
        UserEntity user = userMapper.toEntity(userRequest);
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toUserResponseDTO(savedUser);
	}

}
