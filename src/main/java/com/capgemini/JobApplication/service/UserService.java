package com.capgemini.JobApplication.service;

import java.util.List;

import com.capgemini.JobApplication.dto.UserCreateDto;
import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.dto.UserUpdateDto;

public interface UserService {
	List<UserResponseDto> getAllUsers();
	
	UserResponseDto getUserById (Long id);
	
	UserResponseDto getUserByEmail (String email);
	
	UserResponseDto addUser(UserCreateDto user);
	
	UserResponseDto updateUser(Long id, UserUpdateDto userDto);
	
	void deleteUser(Long id);
}
