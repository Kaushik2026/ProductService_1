package com.backendlld.productservice_1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String productName;
    private String productDescription;
    private double productPrice;
    private String image;


    @ManyToOne
    private Category category;
}
