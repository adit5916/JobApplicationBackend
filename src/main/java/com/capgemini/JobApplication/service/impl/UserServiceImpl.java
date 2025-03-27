package com.capgemini.JobApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.JobApplication.dto.UserCreateDto;
import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.dto.UserUpdateDto;
import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.exception.ResourceNotFoundException;
import com.capgemini.JobApplication.mapper.UserMapper;
import com.capgemini.JobApplication.repository.UserRepository;
import com.capgemini.JobApplication.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private  UserRepository userRepository;
	private UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = userRepository.findAll();
		return userMapper.toUserResponseDTOList(users);
	}

	@Override
	public UserResponseDto getUserById(Long id) {
		UserEntity user = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		return userMapper.toUserResponseDTO(user);
	}

	@Override
	public UserResponseDto getUserByEmail(String email) {
		UserEntity user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
	        return userMapper.toUserResponseDTO(user);
	}

	@Override
	public UserResponseDto addUser(UserCreateDto userDto) {
		Optional<UserEntity> existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        
        UserEntity user = userMapper.toEntity(userDto);
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toUserResponseDTO(savedUser);
	}

	@Override
	public UserResponseDto updateUser(Long id, UserUpdateDto userDto) {
		 UserEntity existingUser = userRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		        
		        // Check if new email already exists (if email is being updated)
		        if (userDto.getEmail() != null && !userDto.getEmail().equals(existingUser.getEmail())) {
		            Optional<UserEntity> userWithEmail = userRepository.findByEmail(userDto.getEmail());
		            if (userWithEmail.isPresent()) {
		                throw new IllegalArgumentException("Email already exists");
		            }
		        }
		        
		        UserEntity updatedUser = userMapper.updateEntityFromDTO(userDto, existingUser);
		        UserEntity savedUser = userRepository.save(updatedUser);
		        return userMapper.toUserResponseDTO(savedUser);
	}

	@Override
	public void deleteUser(Long id) {
		 if (!userRepository.existsById(id)) {
	            throw new ResourceNotFoundException("User not found with id: " + id);
	        }
	        userRepository.deleteById(id);
	    }
	
	
}
