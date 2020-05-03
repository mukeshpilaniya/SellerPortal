package com.iiitb.sellerportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "login")
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private  String password;

    @Column(name = "role")
    private String role;
}
