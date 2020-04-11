package com.iiitb.sellerportal.controller;


import com.iiitb.sellerportal.model.Product;
import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.service.ProductService;
import com.iiitb.sellerportal.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;
    //only for testing purpose
    @GetMapping("/all")
    List<Seller> findAllSeller(){
        return sellerService.findAllSeller();
    }

    @GetMapping("/{sellerId}")
    Optional<Seller> findSellerById(@PathVariable Long sellerId){
        return sellerService.findSellerById(sellerId);
    }

    @PostMapping("/save")
    Seller saveSeller(@RequestBody Seller seller){
        return sellerService.saveSeller(seller);
    }

    @PutMapping("/update")
    Seller updateSeller(@RequestBody Seller seller){
        return sellerService.updateSeller(seller);
    }
    //error
    @DeleteMapping("/delete/{sellerId}")
    String deleteSellerById(@PathVariable Long sellerId){
        return sellerService.deleteSellerById(sellerId);
    }

    @GetMapping("/product/{sellerId}")
    public List<Product> findAllProductOfSeller(@PathVariable Long sellerId){
        return productService.findAllProductOfSeller(sellerId);
    }

    @PostMapping("/product/register")
    public Product registerProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    //error
    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        return productService.deleteProductByid(productId);
    }
}
