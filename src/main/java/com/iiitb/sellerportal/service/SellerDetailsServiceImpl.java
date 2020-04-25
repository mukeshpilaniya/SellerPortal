package com.iiitb.sellerportal.service;


import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SellerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public UserDetails loadUserByUsername(String sellerEmail) throws UsernameNotFoundException {
        Seller seller=sellerRepository.findByEmail(sellerEmail).orElse(null);
        if(seller == null){
            throw new UsernameNotFoundException(sellerEmail);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ seller.getRole()));

        return new org.springframework.security.core.userdetails.User(seller.getEmail(), seller.getPassword(), authorities);

    }
}
