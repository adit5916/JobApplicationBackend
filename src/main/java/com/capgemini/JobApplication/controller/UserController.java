package com.capgemini.JobApplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.JobApplication.dto.UserResponseDto;
import com.capgemini.JobApplication.dto.UserUpdateDto;
import com.capgemini.JobApplication.entity.enums.UserRole;
import com.capgemini.JobApplication.exception.ApiResponse;
import com.capgemini.JobApplication.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
    
    @GetMapping("role/{user_role}")
    public ResponseEntity<List<UserResponseDto>> getUserByRole(@PathVariable UserRole user_role) {
        return ResponseEntity.ok(userService.getUserByRole(user_role));
    }
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserUpdateDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        ApiResponse response = new ApiResponse("User deleted successfully");
        return ResponseEntity.ok(response);
    }
}
