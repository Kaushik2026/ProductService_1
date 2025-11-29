package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product createProduct(Product product);

    void DeleteProduct(Long productId);


    void UpdateProduct(Product product,Long productId);


    void replaceProduct(Long productId,Product product);
}
