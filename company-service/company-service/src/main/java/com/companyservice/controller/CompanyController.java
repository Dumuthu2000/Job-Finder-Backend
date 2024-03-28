package com.companyservice.controller;

import com.companyservice.model.Company;
import com.companyservice.request.LoginRequest;
import com.companyservice.response.LoginResponse;
import com.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/company-service/api")
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //Creating new Company
    @PostMapping(path = "/company")
    public ResponseEntity<Company> createNewCompany(@RequestBody Company company){
        System.out.println("New company created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createNewCompany(company));
    }
    //Get all Companies
    @GetMapping(path = "/companies")
    public ResponseEntity<List<Company>> allCompanies() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(companyService.allCompanies());
    }

    //Login Company
    @PostMapping(path = "/company/login")
    public ResponseEntity<LoginResponse> loginCompany(@RequestBody LoginRequest loginRequest) throws Exception{
        LoginResponse loginResponse = companyService.loginCompany(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    //Get logged company details
    @GetMapping(path = "/company/{companyId}")
    public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable int companyId){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyById(companyId));
    }
}
