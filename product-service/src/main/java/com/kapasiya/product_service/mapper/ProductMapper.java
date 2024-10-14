package com.kapasiya.product_service.mapper;

import com.kapasiya.product_service.dto.request.ProductRequestDto;
import com.kapasiya.product_service.dto.response.ProductResponseDto;
import com.kapasiya.product_service.entities.Product;

public class ProductMapper {

    private ProductMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Product toEntity(ProductRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        return Product.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .build();
    }

    public static ProductResponseDto toRDto(Product product) {
        if (product == null) {
            return null;
        }
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
