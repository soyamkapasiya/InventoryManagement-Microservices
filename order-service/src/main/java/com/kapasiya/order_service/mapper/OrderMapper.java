package com.kapasiya.order_service.mapper;

import com.kapasiya.order_service.dto.request.OrderLineItemDto;
import com.kapasiya.order_service.dto.request.OrderRequest;
import com.kapasiya.order_service.dto.response.OrderResponseDto;
import com.kapasiya.order_service.entities.Order;

import com.kapasiya.order_service.entities.OrderLineItems;
import com.kapasiya.order_service.exceptions.custom.OrderException;
import lombok.experimental.UtilityClass;

import java.util.UUID;


@UtilityClass
public class OrderMapper {

    public static Order toEntity() {
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString().substring(0,6))
                .build();
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


    public static OrderLineItems mapDto(OrderLineItemDto orderLineItemDto){
        if (orderLineItemDto == null){
            throw new OrderException("OrderLineItemDto is null...");
        }
        return OrderLineItems.builder()
                .id(null)
                .quantity(orderLineItemDto.getQuantity())
                .price(orderLineItemDto.getPrice())
                .skuCode(orderLineItemDto.getSkuCode())
                .build();
    }
}
