package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
