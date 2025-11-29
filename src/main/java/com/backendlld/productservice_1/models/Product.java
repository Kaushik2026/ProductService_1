package com.backendlld.productservice_1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String productName;
    private String productDescription;
    private double productPrice;
    private String image;
    private Category category;
}
