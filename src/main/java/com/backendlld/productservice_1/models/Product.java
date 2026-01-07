package com.backendlld.productservice_1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseModel{
    private String productName;
    private String productDescription;
    private double productPrice;
    private String image;

    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JsonIgnore
//    @JsonBackReference
    @JsonIgnoreProperties("products")
    private Category category;


}
