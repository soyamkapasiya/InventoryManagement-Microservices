package com.kapasiya.product_service.controller;

import com.kapasiya.product_service.dto.request.ProductRequestDto;
import com.kapasiya.product_service.dto.response.CustomResponseDto;
import com.kapasiya.product_service.dto.response.ProductResponseDto;
import com.kapasiya.product_service.service.ProductService;
import com.kapasiya.product_service.utils.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CustomResponseDto<Void>> createProduct(
            @Valid @RequestBody ProductRequestDto requestDto) {
        log.info("Creating Product (Controller)");
        CustomResponseDto<Void> response = productService.createProduct(requestDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping()
    public ResponseEntity<CustomResponseDto<List<ProductResponseDto>>> getAllProducts() {
        log.info("Getting All Product (Controller)");
        CustomResponseDto<List<ProductResponseDto>> responseDto = productService.getAllProducts();
        return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
    }

}
