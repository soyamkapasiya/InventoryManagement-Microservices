package com.kapasiya.order_service.mapper;

import com.kapasiya.order_service.dto.request.OrderRequestDto;
import com.kapasiya.order_service.dto.response.OrderResponseDto;
import com.kapasiya.order_service.entities.Order;

import lombok.experimental.UtilityClass;


@UtilityClass
public class OrderMapper {

    public static Order toEntity(OrderRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

    }

    public static OrderResponseDto toRDto(Order order){
        if (order == null){
            return null;
        }
        return OrderResponseDto.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderLineItems(order.getOrderLineItems())
                .build();
    }
}
