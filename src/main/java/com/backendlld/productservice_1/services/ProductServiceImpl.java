package com.backendlld.productservice_1.services;

import com.backendlld.productservice_1.dtos.FakeStoreProductDto;
import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Category;
import com.backendlld.productservice_1.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private RestTemplate restTemplate;

    @Override
    public Product getSingleProductById(Long id) throws ProductNotFoundException{
        throw new ProductNotFoundException(id,"Invalid Id");
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtosList = restTemplate.getForObject(
                "https://fakestoreapi.com/products",FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtosList) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setCategory(new Category());
        product.setId(fakeStoreProductDto.getId());
        product.getCategory().setValue(fakeStoreProductDto.getCategory());
        product.setProductDescription(fakeStoreProductDto.getDescription());
        product.setProductName(fakeStoreProductDto.getTitle());
        product.setProductPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());

        return product;
    }

}

