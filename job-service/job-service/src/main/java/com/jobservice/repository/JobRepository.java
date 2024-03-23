package com.jobservice.repository;

import com.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(nativeQuery = true, value ="SELECT * FROM job j WHERE j.company_name= :companyName")
    List<Job> findJobByCompanyName(@Param("companyName") String companyName);
}
