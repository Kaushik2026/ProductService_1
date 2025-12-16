package com.backendlld.productservice_1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{
    private String value;

//    mapped by is always used in (one to many side)
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;
}
