package com.store.shop.entities;

public enum ProductType
{
    CANDY ("Конфеты"),
    COOKIE("Печенье"),
    TEA("Чай"),
    COFFEE("Кофе");

    private final String displayName;

    ProductType(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

}
