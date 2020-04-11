package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.CompanyProduct;

import java.util.List;

public interface CompanyProductService {
    List<CompanyProduct> findAllProductOfCompany(Long companyId);

    CompanyProduct registerProduct(CompanyProduct companyProduct);

    CompanyProduct updateProduct(CompanyProduct companyProduct);

    String deleteProduct(Long companyProductId);
}
