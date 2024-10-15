package com.kapasiya.order_service.controller;

import com.kapasiya.order_service.dto.request.OrderRequest;
import com.kapasiya.order_service.dto.response.CustomResponseDto;
import com.kapasiya.order_service.dto.response.OrderResponseDto;
import com.kapasiya.order_service.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CustomResponseDto<Void>> createOrder(
            @Valid @RequestBody OrderRequest requestDto){
        return ResponseEntity.ok().body(orderService.createOrder(requestDto));
    }

    @GetMapping
    public ResponseEntity<CustomResponseDto<List<OrderResponseDto>>> getAllOrders(){
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

}
