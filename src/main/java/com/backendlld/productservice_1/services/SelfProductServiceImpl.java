package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.dtos.CreateProductDto;
import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Category;
import com.backendlld.productservice_1.models.Product;
import com.backendlld.productservice_1.repositories.CategoryRepository;
import com.backendlld.productservice_1.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@AllArgsConstructor
public class SelfProductServiceImpl implements ProductService{
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Override
    public Product getSingleProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id,"Product not found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(CreateProductDto dto) {
        // Always find existing category by VALUE

        String categoryValue = dto.getCategoryValue();
        // 1. Validate category input
        if (categoryValue == null || categoryValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }

        Category category = categoryRepository.findByValue(categoryValue)
                .orElseGet(() -> {
                    Category newCat = new Category();
                    newCat.setValue(categoryValue);
                    return categoryRepository.save(newCat);
                });

        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setProductPrice(dto.getProductPrice());
        product.setImage(dto.getImage());
        product.setCategory(category);  // Existing OR newly created
        return productRepository.save(product);
    }

    @Override
    public void DeleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void UpdateProduct(Product product, Long productId) {

    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }
}
