package com.store.shop.controllers;

import com.store.shop.dto.ProductDTO;
import com.store.shop.entities.Product;
import com.store.shop.entities.ProductDescription;
import com.store.shop.entities.ProductType;
import com.store.shop.service.FileStorageService;
import com.store.shop.service.ProductService;
import com.store.shop.utils.mappers.ProductMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController
{
    @Resource(name = "productMapperImpl")
    private ProductMapper productMapper;
    @Resource(name = "defaultProductService")
    private ProductService productService;
    @Resource(name = "defaultFileStorageService")
    private FileStorageService fileStorageService;

    @ModelAttribute("product")
    public Product createProduct() {
        Product product = new Product();
        product.setProductDescription(new ProductDescription());
        return product;
    }

    @GetMapping("/{id}")
    public String getProductPage(Model model, @PathVariable Long id)
    {
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent())
        {
            ProductDTO productDTO = productMapper.toProductDTO(product.get());
            model.addAttribute("product", productDTO);
            return "productPage";
        }
        //TODO amend to error page
        return null;
    }

    @GetMapping("/add")
 //   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getNewProductForm(Model model)
    {
        model.addAttribute("productTypes", ProductType.values());
        return "addNewProductPage";
    }

    @PostMapping("/submit_product")
    public String addNewProduct(
            @ModelAttribute("product") Product product,
            @RequestParam("image") MultipartFile image, // параметр для файла изображения
            Model model,
            RedirectAttributes redirectAttributes) {

        try {
            String imageUrl = fileStorageService.saveFile(image);
            product.setImageUrl(imageUrl);
            productService.saveProduct(product);

            redirectAttributes.addFlashAttribute("message",
                    "Product successfully saved. Product id - " + product.getId());
            return "redirect:/addedProductPage";

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Failed to save product.");
            return "addNewProductPage";
        }
    }

    @GetMapping("/category/{category}")
    public String getProductsByCategory(@PathVariable String category, Model model)
    {
        //TODO change to DTO
        List<Product> productList = productService.getProductsByCategory(category);
        model.addAttribute("productList", productList);
        return "fragments/productList :: catalog";
    }

}
