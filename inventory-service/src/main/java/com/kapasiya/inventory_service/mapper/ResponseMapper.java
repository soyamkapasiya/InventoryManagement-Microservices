package com.kapasiya.inventory_service.mapper;

import com.kapasiya.inventory_service.dto.ResponseDto;
import com.kapasiya.inventory_service.entities.Inventory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseMapper {

    public static ResponseDto responseMap(Inventory inventory){
        return ResponseDto.builder()
                .message("In Stock")
                .quantity(inventory.getQuantity())
                .skuCode(inventory.getSkuCode())
                .build();
    }
}
