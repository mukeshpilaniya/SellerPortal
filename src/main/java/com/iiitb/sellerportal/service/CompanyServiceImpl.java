package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Company;
import com.iiitb.sellerportal.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    //only for testing purpose
    @Override
    public List<Company> findAllCompany(){
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findCompanyById(Long id){
        return companyRepository.findById(id);
    }

    @Override
    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company){
        return  companyRepository.save(company);
    }
}
