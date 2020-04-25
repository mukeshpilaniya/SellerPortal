package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Company;
import com.iiitb.sellerportal.repository.CompanyRepository;
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
public class CompanyDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String companyEmail) throws UsernameNotFoundException {
        Company company=companyRepository.findByEmail(companyEmail).orElse(null);
        if(company == null){
            throw new UsernameNotFoundException(companyEmail);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ company.getRole()));

        return new org.springframework.security.core.userdetails.User(company.getEmail(), company.getPassword(), authorities);

    }
}
