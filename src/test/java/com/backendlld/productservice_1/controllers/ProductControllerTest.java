package com.backendlld.productservice_1.controllers;

import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Category;
import com.backendlld.productservice_1.models.Product;
import com.backendlld.productservice_1.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.servlet.support.WebContentGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;
    @Autowired
    private WebContentGenerator webContentGenerator;

    @Test
    void getSingleProductByIdTest() throws ProductNotFoundException {
//        Arrange
        Product Expectedproduct = new Product();
        Expectedproduct.setId(1L);
        Expectedproduct.setProductName("product10");
        Expectedproduct.setProductDescription("product10Desc");
        Expectedproduct.setProductPrice(101);

        Category Expectedcategory = new Category();

//        Mocking
        when(productService.getSingleProductById(10L)).
                thenReturn(Expectedproduct);

//        Act
        Product returnedProduct = productService.getSingleProductById(10L);
//        Product TProduct = new Product();

//        Assert
        assertEquals(Expectedproduct, returnedProduct);
    }

    @Test
    void getAllProductsTest() {
        List<Product> Expectedproducts = new ArrayList<>();
        Expectedproducts.add(new Product());
        Expectedproducts.add(new Product());
        when(productService.getAllProducts()).thenReturn(Expectedproducts);

        List<Product> returnedproducts = productService.getAllProducts();
        assertEquals(Expectedproducts, returnedproducts);
    }

    @Test
    void createProductTest() {
    }

    @Test
    void deleteProductTest() {
    }

    @Test
    void updateProductTest() {
    }

    @Test
    void replaceProductTest() {
    }
}