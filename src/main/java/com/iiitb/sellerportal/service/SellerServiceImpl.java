package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> findAllSeller(){
        return sellerRepository.findAll();
    }
    @Override
    public Optional<Seller> findSellerById(Long id){
        return  sellerRepository.findById(id);
    }
    @Override
    public Seller saveSeller(Seller seller){
        return sellerRepository.save(seller);
    }
    @Override
    public Seller updateSeller(Seller seller){
        return sellerRepository.save(seller);
    }
    @Override
    public String deleteSellerById(Long id){
        sellerRepository.deleteById(id);
        return "seller id "+id+" deleted";
    }
    @Override
    public String deleteSeller(Seller seller){
        sellerRepository.delete(seller);
        return "seller deleted";
    }
}
