package com.applicationservice.repository;

import com.applicationservice.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Integer > {
    Optional<Application> findByName(String fileName);

    @Query(nativeQuery = true, value ="SELECT a.name FROM application a WHERE a.job_id= :jobId")
    List<Object> findByCredentials(@Param("jobId") int jobId);

    @Query(nativeQuery = true, value ="SELECT COUNT(a.job_id) AS count FROM application a WHERE a.job_id = :jobId")
    int findNumOfApplication(@Param("jobId") int jobId);
}
