package com.backendlld.productservice_1.dtos;

import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import com.backendlld.productservice_1.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductDto {
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String image;
    private String categoryValue;

    public static UpdateProductDto from(Product product){
        UpdateProductDto dto = new UpdateProductDto();
        dto.setProductName(product.getProductName());
        dto.setProductDescription(product.getProductDescription());
        dto.setProductPrice(product.getProductPrice());
        dto.setImage(product.getImage());
        if(product.getCategory() != null){
            dto.setCategoryValue(product.getCategory().getValue());
        }
        return dto;
    }
}
