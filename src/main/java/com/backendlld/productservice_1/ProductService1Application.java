package com.backendlld.productservice_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductService1Application.class, args);
    }

}
