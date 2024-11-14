package com.store.shop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue
    private Long id;
    private ProductType productType;
    private String name;
    private double quantity;
    private double price;
    private String imageUrl;
    @OneToOne(cascade = CascadeType.ALL)
    private ProductDescription productDescription;
}
