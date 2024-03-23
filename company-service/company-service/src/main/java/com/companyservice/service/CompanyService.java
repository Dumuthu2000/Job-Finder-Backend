package com.companyservice.service;

import com.companyservice.model.Company;
import com.companyservice.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Company loginCompany(String email, String password) {
        Company company = companyRepository.findByCredentials(email, password);
        return company;
    }


}