package com.backendlld.productservice_1.repositories;

import com.backendlld.productservice_1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByValue(String value);
    Optional<Category> findById(Long id);
    void deleteById(Long id);
}
