package com.iiitb.sellerportal.service;

import com.iiitb.sellerportal.model.Product;
import com.iiitb.sellerportal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProdcut(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public String deleteProductByid(Long id){
        productRepository.deleteById(id);
        return "product id "+id+" deleted";
    }

    @Override
    public String deleteProduct(Product product){
        productRepository.delete(product);
        return "product deleted";
    }

    @Override
    public List<Product> findAllProductOfSeller(Long sellerId){
        return productRepository.findBySellerId(sellerId);
    }
}
