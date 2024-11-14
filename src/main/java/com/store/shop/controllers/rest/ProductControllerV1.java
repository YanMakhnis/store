package com.store.shop.controllers.rest;

import com.store.shop.entities.Product;
import com.store.shop.service.FileStorageService;
import com.store.shop.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductControllerV1
{
    @Resource (name = "defaultProductService")
    private ProductService productService;

    @Resource(name = "defaultFileStorageService")
    private FileStorageService fileStorageService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> productList = productService.getAvailableProducts();
        if (productList.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        try
        {
            productService.saveProduct(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id)
    {
        Optional<Product> productOptional = productService.getProductById(id);

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/n/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name)
    {
        Optional<Product> productOptional = productService.getProductByName(name);

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Product> removeProduct(@PathVariable Long id)
    {
        try
        {
            productService.removeProductById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Product> removeAllProducts()
    {
        try
        {
            productService.removeAllProducts();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addRandomProduct")
    public ResponseEntity<Product> addRandomProduct()
    {
        try
        {
            Product product = productService.addRandomProduct();
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id)
    {
       return productService.getProductById(id).map(updatedProduct -> {
           updatedProduct.setProductType(product.getProductType());
           updatedProduct.setName(product.getName());
           updatedProduct.setQuantity(product.getQuantity());
           updatedProduct.setPrice(product.getPrice());
           productService.saveProduct(updatedProduct);
           return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
       }).orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }



}
