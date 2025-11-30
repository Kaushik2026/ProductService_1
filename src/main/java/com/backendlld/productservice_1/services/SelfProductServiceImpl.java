package com.backendlld.productservice_1.services;

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
    public Product createProduct(Product product) {
        if(product.getCategory()!=null){
            if(product.getCategory().getId() == null){
                Category category = product.getCategory();
                String categoryValue = category.getValue();
                Optional<Category> optionalCategory = categoryRepository.findByValue(categoryValue);
                if(optionalCategory.isEmpty()){
                    category=categoryRepository.save(category);
                    product.setCategory(category);
                }else{
                    product.setCategory(optionalCategory.get());
                }


            }
        }else{
            throw new RuntimeException("Category cannot be empty");
        }
        return productRepository.save(product);
    }

    @Override
    public void DeleteProduct(Long productId) {

    }

    @Override
    public void UpdateProduct(Product product, Long productId) {

    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }
}
