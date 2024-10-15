package com.kapasiya.inventory_service.exceptions.custom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InventoryException extends RuntimeException{
    private final String message;
}
