package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.models.Category;
import com.backendlld.productservice_1.models.Product;
import com.backendlld.productservice_1.repositories.CategoryRepository;
import com.backendlld.productservice_1.repositories.ProductRepository;
import com.backendlld.productservice_1.repositories.projections.ProductWithTitleAndPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class ProductService1ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery(){
        ProductWithTitleAndPrice p = productRepository.getTitleAndPriceById(11L).get();
        System.out.println("Title: "+p.getTitle());
        System.out.println("Price: "+p.getPrice());
    }
    @Test
    void testQuery2(){
        List<ProductWithTitleAndPrice> p = productRepository.getTitleAndPrice();
        for(ProductWithTitleAndPrice e: p){
            System.out.println("Title: "+e.getTitle()+", Price: "+e.getPrice());
        }
    }

    @Test
    void testCategoryRepo(){
//        categoryRepository.deleteById(6L);

    }
    @Test
    @Transactional
//    to make it work we have to add @Transactional because fetch type is LAZY by default
    void testFetchType(){
//        for this to work fetch type should be EAGER
//        Product product = productRepository.findById(11L).get();

//        here we have list of products so by default fetch type is LAZY,but we can change it to EAGER to
//        fetch categories along with products.
        Category category = categoryRepository.findById(1L).get();

        List<Product> products = category.getProducts();
        System.out.println("CategoryName: "+category.getValue());
        for(Product p: products) {
            System.out.println("Product Name: " + p.getProductName());
        }
    }

}
