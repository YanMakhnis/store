package com.store.shop.service.impl;

import com.store.shop.entities.Product;
import com.store.shop.entities.ProductType;
import com.store.shop.repository.ProductRepository;
import com.store.shop.service.ProductService;
import com.store.shop.utils.ProductUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductService implements ProductService
{
    @Resource
    private ProductRepository productRepository;

    @Override
    public List<Product> getAvailableProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product)
    {

        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id)
    {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name)
    {
        return productRepository.findByName(name);
    }

    @Override
    public void removeProductById(Long id)
    {
        productRepository.deleteById(id);
    }

    @Override
    public void removeAllProducts()
    {
        productRepository.deleteAll();
    }

    @Override
    public Product addRandomProduct()
    {
        Product product = ProductUtils.createRandomProduct();
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        ProductType type = ProductUtils.getProductTypeFromDisplayName(category);
        return productRepository.findProductsByProductType(type);
    }


}
