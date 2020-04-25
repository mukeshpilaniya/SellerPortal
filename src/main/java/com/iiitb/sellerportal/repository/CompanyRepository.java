package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByEmail(String companyEmail);
}
