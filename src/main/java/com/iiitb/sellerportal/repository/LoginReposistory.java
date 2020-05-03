package com.iiitb.sellerportal.repository;

import com.iiitb.sellerportal.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginReposistory extends JpaRepository<Login,Long> {

    Optional<Login> findByEmail(String email);
}
