package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.dtos.CreateProductDto;
import com.backendlld.productservice_1.dtos.UpdateProductDto;
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
    public Product createProduct(CreateProductDto dto) throws IllegalArgumentException{
//          - @NotBlank → null ❌, "" ❌, "   " ❌ (trims + checks non-empty)
//        use this validation for future needs like below:
//          - Custom business rules: categoryValue.startsWith("CAT_")
//          - Complex logic: database/category enum checks
//          - Future requirements
        validateCategoryValue(dto.getCategoryValue());
        // Always find existing category by VALUE
        Category category = getCategory(dto.getCategoryValue());

        return productRepository.save(dto.createProduct(category));
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException{
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException(productId, "Product not found");
        }
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Long productId, UpdateProductDto dto) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId,"Product not found");
        }
        Product product = optionalProduct.get();
        if(dto.getProductName() != null)
            product.setProductName(dto.getProductName());
        if(dto.getProductDescription() != null)
            product.setProductDescription(dto.getProductDescription());
        if(dto.getProductPrice() != null)
            product.setProductPrice(dto.getProductPrice());
        if(dto.getImage() != null)
            product.setImage(dto.getImage());
        if (dto.getCategoryValue() != null && !dto.getCategoryValue().trim().isEmpty()) {
            Category category = getCategory(dto.getCategoryValue());
            product.setCategory(category);
        }
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId,CreateProductDto dto) throws ProductNotFoundException,IllegalArgumentException{
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(productId,"Product not found");
        }

        validateCategoryValue(dto.getCategoryValue());
        Category category = getCategory(dto.getCategoryValue());
        Product product = optionalProduct.get();
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setProductPrice(dto.getProductPrice());
        product.setImage(dto.getImage());
        product.setCategory(category);
        return productRepository.save(product);

    }

    private Category getCategory(String cv){
        String categoryValue = cv.trim();
        Optional<Category> categoryOptional = categoryRepository.findByValue(categoryValue);
        Category category;
        if(categoryOptional.isEmpty()){
            category = new Category();
            category.setValue(categoryValue);
            category = categoryRepository.save(category);
        }else{
            category = categoryOptional.get();
        }
        return category;
    }
    private void validateCategoryValue(String cv){
        if(cv == null || cv.trim().isEmpty()){
            throw new IllegalArgumentException("CategoryValue cannot be null or empty");
        }
    }
}
