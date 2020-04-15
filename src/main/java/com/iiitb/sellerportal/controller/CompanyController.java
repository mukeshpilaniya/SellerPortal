package com.iiitb.sellerportal.controller;

import com.iiitb.sellerportal.model.Company;
import com.iiitb.sellerportal.model.CompanyProduct;
import com.iiitb.sellerportal.model.Product;
import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.repository.CompanyProductRepository;
import com.iiitb.sellerportal.repository.CompanyRepository;
import com.iiitb.sellerportal.repository.ProductRepository;
import com.iiitb.sellerportal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyProductRepository companyProductRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    //only for testing purpose
    @GetMapping("/company/list")
    public List<Company>findAllCompany(){
        return companyRepository.findAll();
    }

    @GetMapping("/company/{companyId}")
    Optional<Company> findCompanyById(@PathVariable Long companyId){
        return companyRepository.findById(companyId);
    }

    @PostMapping("/company/save")
    Company saveCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @PutMapping("/company/update")
    Company updateCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @GetMapping("/company/sellerlist")
    List<Seller> findAllSeller(){
        return sellerRepository.findAll();
    }

    @GetMapping("/company/productlist")
    List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/company/{companyId}/product")
    List<Product> findAllProductOfCompany(@PathVariable Long companyId){
         return companyProductRepository.findByCompanyId(companyId).stream().map(p->p.getProduct()).collect(Collectors.toList());
    }

    @GetMapping("/company/product/seller/{sellerId}")
    public List<Product> findAllProductOfSeller(@PathVariable Long sellerId){
        return productRepository.findBySellerId(sellerId);
    }

    @PostMapping("/company/{companyId}/product/{productId}/register")
    public CompanyProduct registerProduct(@PathVariable Long companyId, @PathVariable Long productId){
            Company company=companyRepository.findById(companyId).orElse(new Company());
            Product product=productRepository.findById(productId).orElse(new Product());
            CompanyProduct companyProduct=new CompanyProduct();
            companyProduct.setCompany(company);
            companyProduct.setProduct(product);
        return companyProductRepository.save(companyProduct);
    }

    @DeleteMapping("/company/{companyId}/product/{productId}/delete")
    public ResponseEntity<?> deleteProduct(@PathVariable Long companyId, @PathVariable Long productId){
        CompanyProduct companyProduct= companyProductRepository.findByCompanyIdAndProductId(companyId,productId);
        System.out.println(companyProduct.getId());
        companyProductRepository.deleteById(companyProduct.getId());
        return ResponseEntity.ok().build();
    }
}
