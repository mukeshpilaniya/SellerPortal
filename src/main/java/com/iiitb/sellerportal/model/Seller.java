package com.iiitb.sellerportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "seller")
@AllArgsConstructor
@NoArgsConstructor
public class Seller implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private  String name;

        @Column(name = "email",unique = true)
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "password")
        private String password;

        @Column(name = "address")
        private String address;

        @Column(name = "role")
        private String role;

        @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller",fetch = FetchType.LAZY)
        private List<Product> product;
}
