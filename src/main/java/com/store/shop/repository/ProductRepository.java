package com.store.shop.repository;

import com.store.shop.entities.Product;
import com.store.shop.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findProductsByProductType(ProductType productType);

}
