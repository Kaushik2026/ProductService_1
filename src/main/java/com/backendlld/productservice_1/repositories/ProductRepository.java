package com.backendlld.productservice_1.repositories;

import com.backendlld.productservice_1.models.Product;
import com.backendlld.productservice_1.repositories.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    @Query("SELECT p.productName as title ,p.productPrice as price FROM products p WHERE p.id = :id")
    Optional<ProductWithTitleAndPrice> getTitleAndPriceById(@PathVariable("id") Long id);

    @Query("Select p.productName as title,p.productPrice as price from products p")
    List<ProductWithTitleAndPrice> getTitleAndPrice();
}
