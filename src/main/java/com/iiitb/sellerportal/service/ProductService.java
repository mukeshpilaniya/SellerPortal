package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProdcut();

    Optional<Product> findProductById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    String deleteProductByid(Long id);

    String deleteProduct(Product product);

    List<Product> findAllProductOfSeller(Long sellerId);
}
