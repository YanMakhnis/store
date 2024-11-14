package com.store.shop.utils;

import com.store.shop.entities.Product;
import com.store.shop.entities.ProductType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductUtils
{
    private static final Random RANDOM = new Random();
    private static final List<String> COOKIE_NAMES = Arrays.asList("Jubilejnoje", "Slodych", "Domashneje", "Kristal");
    private static final List<String> CANDY_NAMES = Arrays.asList("Korovka", "Alenka", "Ozera", "Felix", "KitKat", "Mars",
            "Snickers", "Twix");

    public static Product createRandomProduct()
    {
        Product product = new Product();
        setRandomProductTypeAndName(product);
        product.setPrice(RANDOM.nextDouble(10.0, 200.0));
        product.setQuantity(RANDOM.nextDouble(50.0, 500.0));
        return product;
    }

    private static void setRandomProductTypeAndName(Product product)
    {
        ProductType [] productTypes = ProductType.values();
        ProductType productType = productTypes[RANDOM.nextInt(productTypes.length)];
        product.setProductType(productType);
        String productName;
        if (productType.equals(ProductType.CANDY))
        {
            productName = CANDY_NAMES.get(RANDOM.nextInt(CANDY_NAMES.size()));
            product.setName(productName);
        }
        else if (productType.equals(ProductType.COOKIE))
        {
            productName = COOKIE_NAMES.get(RANDOM.nextInt(CANDY_NAMES.size()));
            product.setName(productName);
        }
    }

    public static ProductType getProductTypeFromDisplayName(String displayName) {
        for (ProductType type : ProductType.values()) {
            if (type.getDisplayName().toLowerCase().equals(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with displayName " + displayName);
    }
}
