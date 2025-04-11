package com.capgemini.JobApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.JobApplication.dto.ApplicationResponseDto;
import com.capgemini.JobApplication.entity.enums.ApplicationStatus;
import com.capgemini.JobApplication.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:4200/")
public class ApplicationController {
	private ApplicationService applicationService;

	public ApplicationController(ApplicationService applicationService) {
		super();
		this.applicationService = applicationService;
	}
	
	@GetMapping
    public ResponseEntity<List<ApplicationResponseDto>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponseDto> getApplicationById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }
    
    @PostMapping("/add/{jobId}")
    public ResponseEntity<ApplicationResponseDto> createApplication(@PathVariable Long jobId) {
        return new ResponseEntity<>(applicationService.addApplication(jobId), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}/{status}")
    public ResponseEntity<ApplicationResponseDto> updateApplication(@PathVariable Long id, @PathVariable ApplicationStatus status) {
        return new ResponseEntity<>(applicationService.updateApplication(id, status), HttpStatus.CREATED);
    }
    
    // Get applications by job ID
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponseDto>> getApplicationsByJobId(@PathVariable Long jobId) {
        return new ResponseEntity<>(applicationService.getApplicationsByJobId(jobId), HttpStatus.OK);
    }
    
    // Get applications by employer ID
    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<ApplicationResponseDto>> getApplicationsByEmployerId(@PathVariable Long employerId) {
        return new ResponseEntity<>(applicationService.getApplicationsByEmployerId(employerId), HttpStatus.OK);
    }
    
    // Get applications by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationResponseDto>> getApplicationsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(applicationService.getApplicationsByUserId(userId), HttpStatus.OK);
    }
}
