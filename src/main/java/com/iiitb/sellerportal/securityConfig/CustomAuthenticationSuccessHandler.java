package com.iiitb.sellerportal.securityConfig;

import com.iiitb.sellerportal.model.Company;
import com.iiitb.sellerportal.model.Seller;
import com.iiitb.sellerportal.repository.CompanyRepository;
import com.iiitb.sellerportal.repository.LoginReposistory;
import com.iiitb.sellerportal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Long id=null;
        String redirectUrl = null;

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(roles.contains("ROLE_SELLER")){
            Seller seller=sellerRepository.findByEmail(authentication.getName()).orElse(null);
            id=seller.getId();
            redirectUrl = "/seller/"+id+"/product";
        }else {
            Company company=companyRepository.findByEmail(authentication.getName()).orElse(null);
            id=company.getId();
            redirectUrl = "/company/"+id+"/product";
        }

        System.out.println("redirectUrl " + redirectUrl);
        if (redirectUrl == null) {
            throw new IllegalStateException();
        }
        new DefaultRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, redirectUrl);
    }

}
