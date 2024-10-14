package com.kapasiya.product_service.exceptions.custom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductException extends RuntimeException {
    private final String message;
}
