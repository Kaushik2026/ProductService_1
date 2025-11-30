package com.backendlld.productservice_1.controllers;

import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Product;
import com.backendlld.productservice_1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Long productId) {

    }

    @PatchMapping("/{id}")//for partial update
    public void UpdateProduct(@PathVariable("id")  Long productId, @RequestBody Product product) {

    }

    @PutMapping("/id")//for entire replacement
    public void replaceProduct(@PathVariable("id") Long productId,@RequestBody Product product) {

    }
}
