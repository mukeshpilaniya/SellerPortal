package com.iiitb.sellerportal.service;


import com.iiitb.sellerportal.model.Login;
import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.repository.LoginReposistory;
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
public class LoginDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginReposistory loginReposistory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login=loginReposistory.findByEmail(email).orElse(null);
        if(login == null){
            throw new UsernameNotFoundException(email);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ login.getRole()));

        return new org.springframework.security.core.userdetails.User(login.getEmail(), login.getPassword(), authorities);

    }
}
