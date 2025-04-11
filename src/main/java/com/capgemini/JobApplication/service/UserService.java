package com.capgemini.JobApplication.service;

import java.util.List;

import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.dto.UserUpdateDto;
import com.capgemini.JobApplication.entity.enums.UserRole;

public interface UserService {
	List<UserResponseDto> getAllUsers();
	
	UserResponseDto getUserById (Long id);
	
	UserResponseDto getUserByEmail (String email);
	
	UserResponseDto updateUser(Long id, UserUpdateDto userDto);
	
	List<UserResponseDto> getUserByRole(UserRole user_role);
	
	void deleteUser(Long id);
}
