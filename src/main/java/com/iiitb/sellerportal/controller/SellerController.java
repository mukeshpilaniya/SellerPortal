package com.iiitb.sellerportal.controller;


import com.iiitb.sellerportal.exception.ResourceNotFoundException;
import com.iiitb.sellerportal.model.Product;
import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.repository.ProductRepository;
import com.iiitb.sellerportal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class    SellerController {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //only for testing purpose
    @GetMapping("/seller/list")
    List<Seller> findAllSeller(){
        return sellerRepository.findAll();
    }

    @GetMapping("/seller/{sellerId}")
    Optional<Seller> findSellerById(@PathVariable Long sellerId){
        return sellerRepository.findById(sellerId);
    }

    @PostMapping("/seller/save")
    Seller saveSeller(@RequestBody Seller seller){
        seller.setRole("SELLER");
        String encodedPassword=passwordEncoder.encode(seller.getPassword());
        seller.setPassword(encodedPassword);
        return sellerRepository.save(seller);
    }

    @PutMapping("/seller/update")
    Seller updateSeller(@RequestBody Seller seller)
    {   seller.setRole("SELLER");
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        return sellerRepository.save(seller);

    }

    @DeleteMapping("/seller/{sellerId}/delete")
    public ResponseEntity<?> deleteSeller(@PathVariable Long sellerId){
        return sellerRepository.findById(sellerId).map(seller -> {
            sellerRepository.delete(seller);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("SellerId " + sellerId + " not found"));
    }

    @GetMapping("/seller/{sellerId}/product")
    public List<Product> findAllProductOfSeller(@PathVariable Long sellerId){
        return productRepository.findBySellerId(sellerId);
    }

    @PostMapping("/seller/{sellerId}/product/register")
    public Product registerProduct(@PathVariable Long sellerId, @RequestBody Product product)
    {
        return sellerRepository.findById(sellerId).map(seller -> {product.setSeller(seller);return productRepository.save(product);}).orElseThrow(()->new ResourceNotFoundException("sellerId " + sellerId + " not found"));
    }
    //method added
    @PutMapping("/seller/{sellerId}/product/{productId}/update")
    public Product updateProduct(@PathVariable Long sellerId,@PathVariable Long productId,@RequestBody Product product){
        Product product1= productRepository.findByIdAndSellerId(productId,sellerId).orElseThrow(()->new ResourceNotFoundException("seller " + sellerId + " with product "+ productId +" not found"));
        product1.setDescription(product.getDescription());
        product1.setDiscount(product.getDiscount());
        product1.setImageUrl(product.getImageUrl());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        productRepository.save(product1);
        return product1;
    }

    @DeleteMapping("/seller/{sellerId}/product/{productId}/delete")
    public ResponseEntity<?> deleteProduct(@PathVariable Long sellerId,@PathVariable Long productId){
        return productRepository.findByIdAndSellerId(productId,sellerId).map(product -> {
            productRepository.delete(product);
            return  ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with productId " + productId + " and sellerId " + sellerId));
    }
}

