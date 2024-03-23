package com.companyservice.repository;

import com.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
   @Query(nativeQuery = true, value ="SELECT * FROM company c WHERE c.email= :email AND  c.password= :password")
   Company findByCredentials(@Param("email") String email, @Param("password") String password);

}
