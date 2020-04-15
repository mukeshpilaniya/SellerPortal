package com.iiitb.sellerportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private  String email;

    @Column(name = "phone_number")
    private String phoneNumber;

}
