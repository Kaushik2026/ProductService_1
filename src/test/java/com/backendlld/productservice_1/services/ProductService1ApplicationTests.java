package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.repositories.ProductRepository;
import com.backendlld.productservice_1.repositories.projections.ProductWithTitleAndPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductService1ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

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

}
