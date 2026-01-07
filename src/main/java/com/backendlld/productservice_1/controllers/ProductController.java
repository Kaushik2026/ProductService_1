package com.backendlld.productservice_1.controllers;

import com.backendlld.productservice_1.dtos.CreateProductDto;
import com.backendlld.productservice_1.dtos.UpdateProductDto;
import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Product;
import com.backendlld.productservice_1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(
                productService.getSingleProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductDto dto) throws IllegalArgumentException {
        Product product = productService.createProduct(dto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
    }

    @PatchMapping("/{id}")//for partial update
    public ResponseEntity<Product> UpdateProduct(@PathVariable("id")  Long productId, @RequestBody UpdateProductDto productDto) throws ProductNotFoundException {

        return new ResponseEntity<>(productService.updateProduct(productId,productDto),HttpStatus.OK);

    }

    @PutMapping("/{id}")//for entire replacement
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long productId,@Valid @RequestBody CreateProductDto productDto) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.replaceProduct(productId,productDto),HttpStatus.OK);
    }

}
