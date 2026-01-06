package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.dtos.CreateProductDto;
import com.backendlld.productservice_1.dtos.UpdateProductDto;
import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product createProduct(CreateProductDto createProductDto);

    void DeleteProduct(Long productId) throws  ProductNotFoundException;


    Product UpdateProduct(Long productId, UpdateProductDto dto) throws ProductNotFoundException;


    Product replaceProduct(Long productId,CreateProductDto dto)throws ProductNotFoundException,IllegalArgumentException;
}
