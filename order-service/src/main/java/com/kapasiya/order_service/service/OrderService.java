package com.kapasiya.order_service.service;

import com.kapasiya.order_service.dto.request.OrderRequest;
import com.kapasiya.order_service.dto.response.CustomResponseDto;
import com.kapasiya.order_service.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {

    CustomResponseDto<Void> createOrder(OrderRequest requestDto);

    CustomResponseDto<List<OrderResponseDto>> getAllOrders();
}
