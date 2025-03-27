package com.capgemini.JobApplication.service;

import com.capgemini.JobApplication.dto.UserCreateDto;
import com.capgemini.JobApplication.dto.UserResponseDto;

public interface AuthService {
	
	UserResponseDto createUser(UserCreateDto userRequest);
}
