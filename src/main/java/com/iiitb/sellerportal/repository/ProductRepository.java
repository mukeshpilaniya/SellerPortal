package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findBySellerId(Long sellerId);
}
