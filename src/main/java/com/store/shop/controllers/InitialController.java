package com.store.shop.controllers;

import com.store.shop.entities.Product;
import com.store.shop.entities.ProductType;
import com.store.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class InitialController
{
    //TODO: replace with resource?
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String hello()
    {
        return "helloPage";
    }

    @GetMapping("/home")
    public String homePage()
    {
        return "first";
    }

    @PostMapping("/addUser")
    public String addNewUser()
    {
        return "addNewUser";
    }

    @GetMapping("/check")
  //  @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public String getAvailableProducts(Model model)
    {
        List<Product> productList = productService.getAvailableProducts();
        model.addAttribute("productList", productList);
        return "availableProducts";
    }

    @GetMapping("/login")
    public String loginUser()
    {
        return "loginPage";
    }

    @GetMapping("/main")
    public String getMainPage(Model model)
    {
        List<String> categories = Stream.of(ProductType.values())
                .map(ProductType::getDisplayName)
                .collect(Collectors.toList());

        List<Product> productList = productService.getAvailableProducts();
        model.addAttribute("categories", categories);
        model.addAttribute("productList", productList);
        return "mainPage";
    }
}
