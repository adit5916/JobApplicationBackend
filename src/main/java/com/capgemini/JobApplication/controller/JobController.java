package com.capgemini.JobApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.JobApplication.dto.JobCreateDto;
import com.capgemini.JobApplication.dto.JobResponseDto;
import com.capgemini.JobApplication.dto.JobUpdateDto;
import com.capgemini.JobApplication.exception.ApiResponse;
import com.capgemini.JobApplication.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:4200/")
public class JobController {
	private JobService jobService;

	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping
    public ResponseEntity<List<JobResponseDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDto> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
    
    @GetMapping("/employer/{id}")
    public ResponseEntity<List<JobResponseDto>> getJobByEmployerId(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobByEmployerId(id));
    }
    
    @GetMapping("/title/{title}")
    public ResponseEntity<List<JobResponseDto>> getJobByTitle(@PathVariable String title) {
        return ResponseEntity.ok(jobService.getJobByTitle(title));
    }
    
    @GetMapping("/employer/email/{email}")
    public ResponseEntity<List<JobResponseDto>> getJobByEmployerEmail(@PathVariable String email) {
        return ResponseEntity.ok(jobService.getJobByEmployerEmail(email));
    }
    
    @PostMapping
    public ResponseEntity<JobResponseDto> createJob(@RequestBody JobCreateDto jobDto) {
        return new ResponseEntity<>(jobService.addJob(jobDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobResponseDto> updateJob(
            @PathVariable Long id,
            @RequestBody JobUpdateDto jobDto) {
        return ResponseEntity.ok(jobService.updateJob(id, jobDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        ApiResponse response = new ApiResponse("Job deleted successfully");
        return ResponseEntity.ok(response);
    }
}
