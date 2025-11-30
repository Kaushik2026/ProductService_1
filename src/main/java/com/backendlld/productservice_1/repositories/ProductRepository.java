package com.backendlld.productservice_1.repositories;

import com.backendlld.productservice_1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    List<Product> findAll();

    Product save(Product product);
}
