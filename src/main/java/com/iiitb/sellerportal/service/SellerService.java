package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    List<Seller> findAllSeller();

    Optional<Seller> findSellerById(Long id);

    Seller saveSeller(Seller seller);

    Seller updateSeller(Seller seller);

    String deleteSellerById(Long id);

    String deleteSeller(Seller seller);
}
