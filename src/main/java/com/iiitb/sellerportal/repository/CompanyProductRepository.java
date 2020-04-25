package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.CompanyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface CompanyProductRepository extends JpaRepository<CompanyProduct,Long> {

    List<CompanyProduct> findByProductId(Long productId);

    List<CompanyProduct> findByCompanyId(Long companyId);
    //not working properly
//    List<CompanyProduct> deleteByCompanyId(Long companyId);

    CompanyProduct deleteByCompanyIdAndProductId(Long companyId,Long productId);
    CompanyProduct findByCompanyIdAndProductId(Long companyId,Long productId);

}
