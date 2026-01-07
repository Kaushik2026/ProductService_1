package com.backendlld.productservice_1.dtos;

import com.backendlld.productservice_1.models.Category;
import com.backendlld.productservice_1.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


    public Product createProduct(Category  category) {
        return Product.builder()
                .productName(this.productName)
                .productDescription(this.productDescription)
                .productPrice(this.productPrice)
                .image(this.image)
                .category(category)
                .build();
    }
}
