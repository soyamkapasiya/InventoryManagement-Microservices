package com.kapasiya.inventory_service.serviceimpl;

import com.kapasiya.inventory_service.dto.CustomResponseDto;
import com.kapasiya.inventory_service.dto.ResponseDto;
import com.kapasiya.inventory_service.entities.Inventory;
import com.kapasiya.inventory_service.exceptions.custom.InventoryException;
import com.kapasiya.inventory_service.mapper.ResponseMapper;
import com.kapasiya.inventory_service.repository.InventoryRepository;
import com.kapasiya.inventory_service.service.InventoryService;
import com.kapasiya.inventory_service.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public CustomResponseDto<ResponseDto> isInStock(String skuCode) {
        log.info("Getting Inventory With SukCode: {}", skuCode);
        try {
            Inventory inventory = inventoryRepository.existsBySkuCode(skuCode).orElse(null);
            if (inventory == null) {
                log.error("Inventory not found with Suk Code: {}", skuCode);
                throw new InventoryException("Inventory not Found...");
            }
            ResponseDto responseDto = ResponseMapper.responseMap(inventory);
            return ResponseUtil.successDataResponse(HttpStatus.OK,
                    "Stock Level Get Successfully", responseDto);
        } catch (InventoryException ix) {
            log.error("An Error Occurred While Getting Inventory: {}", ix.getMessage());
            throw ix;
        }
    }

    @Override
    public CustomResponseDto<List<ResponseDto>> getAllStock() {
        log.info("Getting All Stocks...");
        try {
            List<Inventory> list = inventoryRepository.findAll();
            List<ResponseDto> responseList = list.stream().map(ResponseMapper::responseMap).toList();
            return ResponseUtil.successDataResponse(HttpStatus.OK,
                    "Get All Stock Level Successfully", responseList);
        } catch (InventoryException ix) {
            log.error("An Exception while getting all stock level..");
            throw ix;
        }
    }

}
