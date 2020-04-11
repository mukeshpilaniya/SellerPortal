package com.iiitb.sellerportal.controller;

import com.iiitb.sellerportal.model.Company;
import com.iiitb.sellerportal.model.CompanyProduct;
import com.iiitb.sellerportal.model.Product;
import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.service.CompanyProductService;
import com.iiitb.sellerportal.service.CompanyService;
import com.iiitb.sellerportal.service.ProductService;
import com.iiitb.sellerportal.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyProductService companyProductService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    //only for testing purpose
    @GetMapping("/all")
    public List<Company>findAllCompany(){
        return companyService.findAllCompany();
    }

    @GetMapping("/{companyId}")
    Optional<Company> findCompanyById(@PathVariable Long companyId){
        return companyService.findCompanyById(companyId);
    }

    @PostMapping("/save")
    Company saveCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @PutMapping("/update")
    Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @GetMapping("/seller")
    List<Seller> findAllSeller(){
        return sellerService.findAllSeller();
    }

    @GetMapping("/product")
    List<Product> findAllProduct(){
        return productService.findAllProdcut();
    }

    @GetMapping("/product/{companyId}")
    List<Product> findAllProductOfCompany(@PathVariable Long companyId){
         return companyProductService.findAllProductOfCompany(companyId).stream().map(p->p.getProduct()).collect(Collectors.toList());
    }

    @GetMapping("/product/seller/{sellerId}")
    public List<Product> findAllProductOfSeller(@PathVariable Long sellerId){
        return productService.findAllProductOfSeller(sellerId);
    }

    @PostMapping("/product/register")
    public CompanyProduct registerProduct(@RequestBody CompanyProduct companyProduct){
        return companyProductService.registerProduct(companyProduct);
    }

//    @PutMapping("/product/update")
//    public CompanyProduct updateProduct(@RequestBody CompanyProduct companyProduct){
//        return  companyProductService.updateProduct(companyProduct);
//    }

    @DeleteMapping("/product/delete")
    public String deleteProduct(@PathVariable Long companyProductId){
        return companyProductService.deleteProduct(companyProductId);
    }
}
