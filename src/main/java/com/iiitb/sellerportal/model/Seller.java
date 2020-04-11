package com.iiitb.sellerportal.model;

import javax.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {
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

    public Seller() {
    }
    public Seller(String name,String email,String password,String phoneNumber,String address) {
        this.name=name;
        this.password=password;
        this.email=email;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
