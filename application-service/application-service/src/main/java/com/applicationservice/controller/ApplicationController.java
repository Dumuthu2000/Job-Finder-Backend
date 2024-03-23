package com.applicationservice.controller;

import com.applicationservice.model.Application;
import com.applicationservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping(path = "/newApplication")
    public ResponseEntity<Application> createNewCompany(@RequestBody Application application){
        System.out.println("New Application sent successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.sendApplication(application));
    }
}
