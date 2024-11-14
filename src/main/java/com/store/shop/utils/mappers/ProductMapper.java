package com.store.shop.utils.mappers;

import com.store.shop.dto.ProductDTO;
import com.store.shop.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper
{
    ProductDTO toProductDTO(Product product);

    Product toEntity(ProductDTO productDTO);
}
