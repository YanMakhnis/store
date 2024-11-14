package com.store.shop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductDescription
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String composition;




}
