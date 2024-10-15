package com.kapasiya.inventory_service.service;

import com.kapasiya.inventory_service.dto.CustomResponseDto;
import com.kapasiya.inventory_service.dto.ResponseDto;

import java.util.List;

public interface InventoryService {
    CustomResponseDto<ResponseDto> isInStock(String skuCode);

    CustomResponseDto<List<ResponseDto>> getAllStock();
}
