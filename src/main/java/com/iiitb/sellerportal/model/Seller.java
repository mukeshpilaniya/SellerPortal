package com.iiitb.sellerportal.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "seller")
public class Seller implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private  String name;

        @Column(name = "email")
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "password")
        private String password;

        @Column(name = "address")
        private String address;

        @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "seller",fetch = FetchType.LAZY)
        private List<Product> product;
}
