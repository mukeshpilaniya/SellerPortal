package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
