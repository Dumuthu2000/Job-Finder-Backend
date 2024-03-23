package com.applicationservice.service;

import com.applicationservice.model.Application;
import com.applicationservice.repository.ApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Application sendApplication(Application application){
        return applicationRepository.save(application);
    }

}