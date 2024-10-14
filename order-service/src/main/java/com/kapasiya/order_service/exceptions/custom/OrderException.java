package com.kapasiya.order_service.exceptions.custom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderException extends RuntimeException {
    private final String message;
}
