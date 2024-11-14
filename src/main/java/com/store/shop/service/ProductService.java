package com.store.shop.service;

import com.store.shop.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService
{
    List<Product> getAvailableProducts();
    void saveProduct(Product product);

    Optional<Product> getProductById(Long id);

    void removeProductById(Long id);

    void removeAllProducts();

    Optional<Product> getProductByName(String name);

    Product  addRandomProduct();

    List<Product> getProductsByCategory(String category);

}
