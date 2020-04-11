package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAllCompany();

    Optional<Company> findCompanyById(Long id);

    Company saveCompany(Company company);

    Company updateCompany(Company company);
}
