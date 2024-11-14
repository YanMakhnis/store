package com.store.shop.dto;

import com.store.shop.entities.ProductDescription;
import com.store.shop.entities.ProductType;
import lombok.Data;

@Data
public class ProductDTO
{
    //TODO: what to do if require more info regarding product
    private ProductType productType;
    private String name;
    private double price;
    private ProductDescription productDescription;
}
