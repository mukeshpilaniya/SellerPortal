package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller,Long> {

    Optional<Seller> findByEmail(String email);
    Seller findByPhoneNumber(Long number);
}
