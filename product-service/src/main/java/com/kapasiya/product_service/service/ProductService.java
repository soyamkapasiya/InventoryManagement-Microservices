package com.kapasiya.product_service.service;

import com.kapasiya.product_service.dto.request.ProductRequestDto;
import com.kapasiya.product_service.dto.response.CustomResponseDto;
import com.kapasiya.product_service.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    CustomResponseDto<Void> createProduct(ProductRequestDto requestDto);

    CustomResponseDto<List<ProductResponseDto>> getAllProducts();
}
