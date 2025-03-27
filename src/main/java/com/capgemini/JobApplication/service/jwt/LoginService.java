package com.capgemini.JobApplication.service.jwt;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService {
	
	UserDetailsService userDetailsService();
}
