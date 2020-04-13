package com.iiitb.sellerportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private  String imageUrl;

    @Column(name = "price")
    private int price;

    @Column(name = "discount")
    private int discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Seller seller;

}
