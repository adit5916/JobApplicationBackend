package com.capgemini.JobApplication.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.JobApplication.dto.AuthenticationRequest;
import com.capgemini.JobApplication.dto.AuthenticationResponse;
import com.capgemini.JobApplication.dto.UserCreateDto;
import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.entity.UserEntity;
import com.capgemini.JobApplication.repository.UserRepository;
import com.capgemini.JobApplication.service.AuthService;
import com.capgemini.JobApplication.service.jwt.LoginService;
import com.capgemini.JobApplication.utils.JWTUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {
	
	private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final LoginService userService;
    private  final JWTUtil jwtUtil;
    private  final UserRepository userRepository;



    public AuthController(AuthService authService, AuthenticationManager authenticationManager, LoginService userService, JWTUtil jwtUtil, UserRepository userRepository) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }
	
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody UserCreateDto userDto){
		UserResponseDto addedUser = authService.createUser(userDto);
		if(addedUser == null) 
			return new ResponseEntity<>("Customer not added", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<UserResponseDto>(addedUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws
            BadCredentialsException,
            DisabledException,
            UsernameNotFoundException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            System.out.println("Bad credentials: " + e.getMessage());
            throw new BadCredentialsException("Incorrect username or password.");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<UserEntity> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        String jwt = jwtUtil.generateToken(userDetails); // Token generation on successful login

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalUser.isPresent()) {
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUser_role());
        }
            return authenticationResponse;
//
        }

}
