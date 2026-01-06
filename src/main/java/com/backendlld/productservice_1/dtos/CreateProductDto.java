package com.backendlld.productservice_1.dtos;

import com.backendlld.productservice_1.models.Category;
import com.backendlld.productservice_1.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateProductDto {
    @NotBlank(message = "Product name required")
    private String productName;
    @NotBlank(message = "Category required")
    private String categoryValue;
    @NotBlank(message = "Product description required")
    private String productDescription;
    @NotNull(message = "Price required")  // For Double
    @PositiveOrZero(message = "Price must be >= 0")
    private Double productPrice;
    private String image;

//    public static CreateProductDto from(Product product){
//        CreateProductDto createProductDto = new CreateProductDto();
//        if(product.getCategory() != null) {
//            String categoryValue = product.getCategory().getValue();
//            if (categoryValue == null || categoryValue.trim().isEmpty()) {
//                throw new IllegalArgumentException("CategoryValue cannot be empty");
//            }
//            createProductDto.setCategoryValue(product.getCategory().getValue());
//        }else{
//            throw new IllegalArgumentException("Category cannot be null");
//        }
//
//
//        createProductDto.setProductName(product.getProductName());
//        createProductDto.setProductDescription(product.getProductDescription());
//        createProductDto.setProductPrice(product.getProductPrice());
//        createProductDto.setImage(product.getImage());
//        return createProductDto;
//    }
}
