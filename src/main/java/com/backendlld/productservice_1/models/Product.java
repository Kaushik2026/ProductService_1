package com.backendlld.productservice_1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String productName;
    private String productDescription;
    private double productPrice;
    private String image;

    @ManyToOne(cascade = CascadeType.PERSIST)//persist means we don't need to add additional code to save
    // internal object like category
    //while saving product(check SelfProductServiceImpl.createProduct method);
//    @JsonIgnore
//    @JsonBackReference
    @JsonIgnoreProperties("products")
    private Category category;
}
