package com.jobservice.controller;

import com.jobservice.model.Job;
import com.jobservice.response.LoginCompanyJobs;
import com.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // Allow requests from frontend
@RestController
@RequestMapping(path = "/job-service/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping(path = "/jobs")
    public ResponseEntity<Job> createNewCompany(@RequestBody Job job) throws Exception{
        System.out.println("New Job created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.createNewJob(job));
    }

    //Get all jobs
    @GetMapping(path = "/jobs")
    public ResponseEntity<List<Job>> getAllJobs() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getAllJobs());
    }

    //Display all jobs which created by given company
    @PostMapping(path = "/job-list")
    public ResponseEntity<List<Job>> getJobsByCompanyName(@RequestBody LoginCompanyJobs loginCompanyJobs) throws Exception {
        List<Job> jobs = jobService.getJobsByCompanyName(loginCompanyJobs.getCompanyName());
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }
    //Get job by Id
    @GetMapping(path = "/job/{jobID}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable int jobID){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getJobById(jobID));
    }
    //Edit job
    @PutMapping(path = "/job/updateJob")
    public ResponseEntity<Job> updateJobByJobId(@RequestBody Job job){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.updateJobByJobId(job));
    }

}
