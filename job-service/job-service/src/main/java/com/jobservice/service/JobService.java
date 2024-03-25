package com.jobservice.service;


import com.jobservice.model.Job;
import com.jobservice.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Job createNewJob(Job job) throws Exception{
        return jobRepository.save(job);
    }


    public List<Job> getAllJobs() throws Exception{
        return jobRepository.findAll();
    }

    public List<Job> getJobsByCompanyName(String companyName) {
        List<Job> jobs = (List<Job>) jobRepository.findJobByCompanyName(companyName);
        return jobs;
    }

    public Job updateJobByJobId(Job job) {
        return jobRepository.save(job);
    }

    public Optional<Job> getJobById(int jobID) {
        return jobRepository.findById(jobID);
    }
}