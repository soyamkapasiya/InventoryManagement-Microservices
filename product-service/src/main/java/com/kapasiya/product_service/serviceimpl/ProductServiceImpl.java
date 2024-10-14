package com.kapasiya.product_service.serviceimpl;

import com.kapasiya.product_service.dto.request.ProductRequestDto;
import com.kapasiya.product_service.dto.response.CustomResponseDto;
import com.kapasiya.product_service.dto.response.ProductResponseDto;
import com.kapasiya.product_service.entities.Product;
import com.kapasiya.product_service.exceptions.custom.ProductException;
import com.kapasiya.product_service.mapper.ProductMapper;
import com.kapasiya.product_service.repository.ProductRepository;
import com.kapasiya.product_service.service.ProductService;
import com.kapasiya.product_service.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public CustomResponseDto<Void> createProduct(ProductRequestDto requestDto) {
        log.info("Creating Product With Request: {}", requestDto);
        try {
            if (productRepository.existsByName(requestDto.getName())) {
                log.error("Product With Name {} Already Exist.", requestDto.getName());
                return ResponseUtil.errorMessageResponse(HttpStatus.BAD_REQUEST,
                        "Product With Name " + requestDto.getName() + " Already Exist.");
            }
            Product product = ProductMapper.toEntity(requestDto);
            String productId = productRepository.save(product).getId();
            log.info("Product Created With Id: {}", productId);
            return ResponseUtil.successMessageResponse(HttpStatus.CREATED,
                    "Product Created Successfully...");
        } catch (ProductException px) {
            log.error("Unsuspected Error Occurred While Creating the Product: {}", px.getMessage());
            throw px;
        } catch (Exception ex) {
            log.error("Exception occurred while creating product entry: {}. Full logs: ", ex.getMessage(), ex);
            throw new ProductException("Exception: " + ex.getMessage());
        }
    }

    @Override
    public CustomResponseDto<List<ProductResponseDto>> getAllProducts() {
        log.info("Getting All Products...");
        try {
            List<Product> list = productRepository.findAll();
            List<ProductResponseDto> response = list.stream().map(ProductMapper::toRDto).toList();
            return ResponseUtil.successDataResponse(HttpStatus.OK, "Get All Products", response);
        } catch (ProductException px) {
            log.error("An Exception Occurred While Getting All Products...");
            throw px;
        } catch (Exception e) {
            throw new ProductException("Exception Occurred While Getting All Products: " + e.getMessage());
        }
    }
}
