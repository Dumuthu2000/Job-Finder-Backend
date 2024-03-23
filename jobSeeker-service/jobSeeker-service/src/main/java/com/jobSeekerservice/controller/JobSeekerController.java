package com.jobSeekerservice.controller;

import com.jobSeekerservice.model.JobSeeker;
import com.jobSeekerservice.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jobSeeker")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping(path = "/addJobSeeker")
    public ResponseEntity<JobSeeker> createNewCompany(@RequestBody JobSeeker jobSeeker){
        System.out.println("New company created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(jobSeekerService.createNewJobSeeker(jobSeeker));
    }
}
