package com.companyservice.service;

import com.companyservice.model.Company;
import com.companyservice.repository.CompanyRepository;
import com.companyservice.response.LoginResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Company createNewCompany(Company company){
        return companyRepository.save(company);
    }
    public List<Company> allCompanies() throws Exception{
        return companyRepository.findAll();
    }

    public LoginResponse loginCompany(String email, String password) {
        Object result = companyRepository.findByCredentials(email, password);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCompanyId((Integer) result);
        return loginResponse;
    }
    public Optional<Company> getCompanyById(int companyId) {
        return companyRepository.findById(companyId);
    }
}