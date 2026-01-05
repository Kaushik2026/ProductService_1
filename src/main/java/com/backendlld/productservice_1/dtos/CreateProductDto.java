package com.backendlld.productservice_1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private String productName;
    private String categoryValue;  // ← Key change!
    private String productDescription;
    private Double productPrice;
    private String image;
}
