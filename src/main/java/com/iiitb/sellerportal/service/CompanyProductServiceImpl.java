package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.CompanyProduct;
import com.iiitb.sellerportal.repository.CompanyProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyProductServiceImpl implements  CompanyProductService {

    @Autowired
    private CompanyProductRepository companyProductRepository;

    @Override
    public List<CompanyProduct> findAllProductOfCompany(Long companyId){
        return companyProductRepository.findByCompanyId(companyId);
    }

    @Override
    public CompanyProduct registerProduct(CompanyProduct companyProduct){
        return companyProductRepository.save(companyProduct);
    }

    @Override
    public CompanyProduct updateProduct(CompanyProduct companyProduct){
        return companyProductRepository.save(companyProduct);
    }

    @Override
    public  String deleteProduct(Long companyProductId){
        companyProductRepository.deleteById(companyProductId);
        return "deleted succeddfully";
    }
}
