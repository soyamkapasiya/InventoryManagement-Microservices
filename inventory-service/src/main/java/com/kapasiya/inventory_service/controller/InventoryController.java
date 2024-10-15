package com.kapasiya.inventory_service.controller;

import com.kapasiya.inventory_service.dto.CustomResponseDto;
import com.kapasiya.inventory_service.dto.ResponseDto;
import com.kapasiya.inventory_service.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    public ResponseEntity<CustomResponseDto<ResponseDto>> getStock(
            @Valid @PathVariable String skuCode){
        return ResponseEntity.ok().body(inventoryService.isInStock(skuCode));
    }

    @GetMapping
    public ResponseEntity<CustomResponseDto<List<ResponseDto>>> getAllStock(){
        return ResponseEntity.ok().body(inventoryService.getAllStock());
    }
}
